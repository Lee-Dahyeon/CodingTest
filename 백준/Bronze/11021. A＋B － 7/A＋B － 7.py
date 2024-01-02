T=int(input())
list=[]
for i in range(T):
    a,b=map(int,input().split())
    sum=a+b
    list.append(sum)
for i in range(len(list)):
    print(f"Case #{i+1}: {list[i]}")