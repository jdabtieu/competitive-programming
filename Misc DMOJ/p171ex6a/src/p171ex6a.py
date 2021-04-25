# Golfed 4/17/2021 @jdabtieu
# Python 2, 68 bytes
print "{:.4f}".format(max([float(input()) for _ in range(input())]))
