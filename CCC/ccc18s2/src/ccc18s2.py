arr = [list(map(int, input().split(" "))) for i in range(int(input()))]
for i in range(4):
    if arr[0][0] < arr[1][0] and arr[0][0] < arr[0][1]:
        print('\n'.join(' '.join(str(x) for x in row) for row in arr))
    arr = list(zip(*arr[::-1]))