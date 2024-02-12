# 1748번
n=int(input())
max=0
start=1
length=1

while start<=n:
    end=start*10-1
    if end>n:
        end=n
    max+= (end-start+1) *length
    start=end+1
    length+=1
print(max)