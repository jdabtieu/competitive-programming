n = int(input())
x = [0, 0, 0, 0, 0]
for i in range(n):
  line = input()
  for j in range(len(line)):
    if line[j] == 'Y':
      x[j] += 1

ans = max(x)
sol = ""
for i in range(5):
  if x[i] == ans:
   sol += f"{i + 1},"
print(sol[:-1])
