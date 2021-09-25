for _ in range(int(input())):
    n, t = input().split(maxsplit=1)
    n = int(n)
    print(_+1, t[:n-1] + t[n:])
