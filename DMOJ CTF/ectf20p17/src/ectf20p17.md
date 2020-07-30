## Problem Description
### DMOJ Capture The Flag '20 B1 - Super Secure Pseudorandom Number Generator
Can you retrieve the flag from this program? You will need to submit your interactive solution to the judge.

[main.c](https://static.dmoj.ca/data/ctf/ectf20/4ce3cd2c466d954ffe0fd56b45967d1e-main.c) `4ce3cd2c466d954ffe0fd56b45967d1e` `2.6K`

The judge will run `main.c`. You must interact with the judge with a solution through the standard input and output streams. Anything the judge outputs will be in your standard input stream, and anything you output to standard output will be forwarded to the judge as input. If your solution successfully causes the judge to print the flag to its standard error stream, you will receive AC. Otherwise, you will receive WA. Note that at no point during the judging will your program receive the flag.

## Solving Process
Let's take a look at main.c. The first line inside main is `srand(time(NULL));`, suggesting that the program uses a seed based on the current time to generate random numbers. This could be a vulnerability, as we'll see later. But for now, let's keep it in mind and move on.

The next bit of code looks pretty robust, and tells us that this is a shop interface.
```c
int balance = 999999999;
    printf("Welcome to the secure pseudorandom number generator!\n");
    while (1)
      {
        printf("1. Generate some numbers ($500000000 each).\n");
        printf("2. Generate the flag ($1000000000 each).\n");
        printf("3. Quit.\n");
        printf("Your current balance is $%d.\n", balance);
        printf("===========================================\n");
        char c = '\0';
        int count;
        while (c = getchar(), !('1' <= c && c <= '3'));
        switch(c)
```

Looks like the author made sure c must be 1, 2, or 3. Also, we are $1 short of buying the flag. At this point, there were two attacks I had in mind - either forcing the program to jump to printing the flag using a buffer overflow, or use integer overflow to increase our balance.

I'm going to look through the switch from the bottom-up, so that I can verify that the quit option isn't vulnerable. Indeed, it just returns 1. Now, let's take a look at case 2:
```c
balance -= 1000000000LL;
if (balance < 0)
 {
    printf("You do not have enough money!\n");
    return 1;
 }
```
So the program subtracts 1000000000 from our balance, and exits if we don't have enough money.
```c
printf("Enter the secret code: ");
while (scanf("%d", &count) != 1);
if (count != rand())
 {
    printf("Wrong number!\n");
    return 1;
 }
```
So after we have enough money, we then have to enter an integer which should match with a random number. When I was first looking at this, I had no idea that this could be manipulated. However, I did figure this out a bit later. This is the second vulnerability we need to exploit to get the flag.
```c
FILE *fp = fopen(argv[1], "r");
if (fp == NULL)
  {
    printf("Could not open flag file.\n");
    return 3;
  }
char flag[100];
fgets(flag, 80, fp);
flag[strlen(flag) - 1] = '\0';

printf("Success!\nHere is your flag: %s\n", flag);
fprintf(stderr, "Here is your flag %s", flag);
return 0;
```
This looks normal, it just prints the flag to stderr.

Now at this point, I figured that a buffer overflow attack would probably be out of the question, since I would need to jump to line 59, which I had no idea of knowing the memory address of. An integer overflow in the first part would most likely be the solution, followed by some way of manipulating the random number generator.

```c
printf("Each generated number costs $500000000.\n");
printf("How many numbers would you like to generate (max 20)?\n");
while (scanf("%d", &count) != 1);
if (!(1 <= count && count <= 20))
  {
    printf("Number %d not in range.\n", count);
    return 1;
  }
```
Standard code to get an integer in the range of 1 <= count <= 20. Let's read on.

```c
else if (500000000 * count > balance)
  {
    printf("You do not have enough money!\n");
    return 1;
  }
balance -= 500000000 * count;
```

We found the first vulnerability that we need to exploit!
To get an integer overflow (about 2.147 billion) we only need to purchase 5 flags. From now, we just need to figure out how many flags to buy such that the balance of 500m * count overflows into a negative number, and isn't so large that it would cause balance to also overflow. 

I found that 16 flags works nicely, as 500,000,000 * 16 = -589,934,592. (Side note: I figured this out using Windows 10's default calculator app, setting it in programmer mode and changing the mode to DWORD (32-bit signed integer).) This gives us enough more than enough money to buy the flag, but also not too much to the point that balance would overflow.

Buying 16 flags, the program prints 16 random numbers and then brings us back to the main menu. Now, our balance is indeed enough to buy the flag, so let's select option 2. As expected we got past the code that prints `You do not have enough money`. Now we are prompted for the secret code.

Remember how I said earlier that the random number generator was vulnerable? It turns out that `srand(time(NULL))` sets the random seed to the current time, in seconds. That means, if we hypothetically were to start a second program within the same second as this and also run `srand(time(NULL))`, we would generate the same random numbers.

We need to first call rand() 16 times to discard the first 16 random numbers (from the earlier integer overflow), and if all works out, calling rand() a 17th time should give us the same random number as the program.

Here's the script I wrote to get the flag (If this or some other script doesn't work on the first try, try resubmitting. It's possible that one program started at X:XX:997 and the other one started at X:XX+1:001 or something like that):

```c
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main() {
    srand(time(NULL));
    printf("%d\n", 1);
    printf("%d\n", 16);
    printf("%d\n", 2);
    for (int i = 0; i < 16; i++) rand();
    printf("%d\n", rand());
}
```

Analysis of my code:
1. Set the seed to the same seed as in the program
2. Print 1 to go to the random numbers menu
3. Print 16 to purchase 16 random numbers <--- Integer overflow
4. Print 2 to go to the purchase flag section
5. Discard the first 16 random numbers
6. Print the 17th random number <--- srand(time(NULL)) vulnerability

## Flag
`ctf{sup3r_s3cur3_prng_453f75a523ae3c}`
