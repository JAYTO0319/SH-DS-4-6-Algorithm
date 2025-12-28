# 목적지에 도달하기 위해 [가로지르기]와 [직진하기] 2가지 방향으로 움직인다.
# 1. 가로지르기 (DO or NOT)
# (가로 + 세로) > 대각선 -> 최대한 가로지른 후 직진한다 (가로지르기 O)
# (가로 + 세로) < 대각선 -> 직진한다 (가로지르기 X)
# 2. 직진하기 (How)
# 가로(세로) * 2 < 대각선 * 2 -> 가로(세로) 방향으로 직진한다
# 가로(세로) * 2 > 대각선 * 2 -> 대각선으로 올라갔다 내려갔다를 반복한다

x, y, w, s = map(int, input().split())

# 가로지른 후 직진
if 2 * w > s:
    # 가로지르기
    time = s * min(x, y)
    # 직진
    if 2 * w > 2 * s: # 대각선으로 올라갔다 내려갔다 반복
        remain = abs(x - y)
        if remain % 2 == 0:
            time += s * remain
        else:
            time += s * (remain - 1) + w
    else: # 한 방향(가로 또는 세로)로 일직선
        time += w * abs(x - y)
# 직진만
else:
    time = w * (x + y)

print(time)
