def binSearch(n, arr):
    result = 0
    s, e = 0, len(arr)-1
    while s<e:
        m = (s+e)//2
        if arr[m]>n:
            e = m-1
        else:
            s = m+1
    if n==arr[s] or n==arr[s-1]:
        result = 1
    return result

N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
X = list(map(int, input().split()))
for n in X:
    print(binSearch(n,A))
