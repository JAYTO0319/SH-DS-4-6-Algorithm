def binSearch(n, arr):
    result = -1
    s, e = 0, len(arr)-1
    while s<e:
        m = (s+e)//2
        if arr[m]>n:
            e = m-1
        else:
            s = m+1
    if n==arr[s] :
        result = s
    elif n==arr[s-1]:
        result = s-1
    return result

N, M = map(int, input().split())

count = {}
A = []
for _ in range(N):
    num = int(input())
    A.append(num)
    if num in count:
        count[num] += 1
    else:
        count[num] = 1
B = sorted(A)
# print(B)
for _ in range(M):
    num = int(input())
    position = binSearch(num, B)
    if position==-1:
        print(-1)
    else:
        print(position - count[num] + 1)
