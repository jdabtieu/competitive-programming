"""
 1. Look at the sample input.
 2. The sample input contains a 2. Then there are 56 lines, and each line contains 28 real numbers.
 3. Each of the 56×28 real numbers are in the form 0.xxxxx.
 4. Maybe these real numbers describe an image or something?
 5. Discover what you need to do to solve the problem.
 6. Try to Google the solution.
 7. Realize that >95% of Google is useless.
 8. Lie down.
 9. Try not to cry.
10. Cry a lot.
11. ???
12. Get 40 easy points and experience PP rain!
13. Realize that this is the rudest "Hello, World!" problem. At least you can solve a lot of similar problems now.
"""
# > Wait a second, that's the editorial, not the solution...
# @ What, were you looking for free points?
# > Ye-I mean no I just wanted to look at your code
# @ No free points here :P
# @ But, here's a random encoder
# @ Feel free to poke around with item
# @ But it is nonstandard and you won't find anything on the web about it
# @ It can reach up to 320% compression if you want it to
# @ But only if you use it correctly
# @ Also, no decoder provided. I might be nice but I'm not that nice
# > ...
# @ Go solve this problem on your own. There are no free answers here
# > ...
# @ Good luck
# > [user] has disconnected.





# paste your w1 here
w1 = ...

def encode(num) -> str:
    neg = num < 0
    num = abs(int(num * 100000))
    if neg:
        num += 100000
    first = num // 4096 + 48
    num %= 4096
    mid = num // 64 + 48
    post = num % 64 + 48
    returns = ""
    if first == 92:
        returns += "\\\\"
    else:
        returns += chr(first)
    if mid == 92:
        returns += "\\\\"
    else:
        returns += chr(mid)
    if post == 92:
        returns += "\\\\"
    else:
        returns += chr(post)
    return returns


file = open('w1done.txt', 'w')
file.write("w1e = ['")
for array in w1:
    output = ""
    for item in array:
        output += encode(item)
    file.write(output)
    file.write("','")
file.close()
file = open('w1done.txt', 'r')
contents = file.read()[:-2]
file.close()
file = open('w1done.txt', 'w')
file.write(contents)
file.write(']')
file.close()