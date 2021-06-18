l=[]
for i in range(26): l.append(0)

s=input()
for i in range(len(s)): l[ord(s[i])-ord('a')]+=1

sum=0
for i in range(1,len(l)+1): sum+=i*l[i-1]

print(str(sum))
