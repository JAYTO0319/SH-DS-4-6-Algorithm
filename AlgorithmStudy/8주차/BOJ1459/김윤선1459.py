import sys

x, y, w, s = map(int, sys.stdin.readline().strip().split(" "))
#대각선으로 가로 지르지 않을 때
result = (x + y) * w

if 2*w>s:
    result = min(result ,min(x, y) * s + abs(x - y) * w)

if (x+y)%2 == 0:
    result = min(result, max(x,y)*s)
else:
    result = min(result, (max(x,y)-1)*s+w)

    
print(result)    
