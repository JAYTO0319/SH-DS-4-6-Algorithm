import sys

X, Y, W, S = map(int, sys.stdin.readline().split())

# 1) 직선 이동만
case1 = (X + Y) * W

# 2) 대각선 최대 활용
if (X + Y) % 2 == 0:
    case2 = max(X, Y) * S
else:
    case2 = (max(X, Y) - 1) * S + W

# 3) 대각선 일부 + 직선
case3 = min(X, Y) * S + abs(X - Y) * W

print(min(case1, case2, case3))
