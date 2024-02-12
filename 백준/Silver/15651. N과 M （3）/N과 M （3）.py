#15649번
n,m=map(int, input().split())
# global use_list, num_list
use_list=[False]*n
num_list=[0]*m


def go(index, n,m):
  if index==m:
    print(*num_list)
    return
  for i in range(n):
        use_list[i]=True
        num_list[index]=i+1
        go(index+1,n,m)
        use_list[i]=False


go(0,n,m)
