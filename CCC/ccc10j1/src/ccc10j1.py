num = int(input())

if num < 6:
    if num % 2 == 0:
        print(int(num / 2 + 1))
    else:
        print(int((num + 1) / 2))
elif num == 6:
    print(3)
elif num < 9:
    print(2)
else:
    print(1)
