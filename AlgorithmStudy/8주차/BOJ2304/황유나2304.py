import sys
input = sys.stdin.readline

n = int(input())
columns = []
for _ in range(n):
    columns.append(tuple(map(int, input().split())))

columns.sort(key = lambda x:x[0]) # 기둥의 왼쪽 위치를 기준으로 오름차순 정렬
max_l, max_h = max(columns, key = lambda x:x[1]) # 가장 높은 기둥의 왼쪽 위치와 높이

# 스택에 유효한 기둥만 남기기 (오름차순 -> 내림차순)
stack = []
for l, h in columns:
    # 오름차순
    if l <= max_l:
        if not stack or h > stack[-1][1]:
            stack.append((l, h))
    # 내림차순
    else: # l > max_l
        while h > stack[-1][1]:
            stack.pop()
        stack.append((l, h))

# 창고 면적 구하기
total = 0
for i in range(len(stack)):
    if stack[i][0] < max_l:
        total += stack[i][1] * (stack[i+1][0] - stack[i][0])
    elif stack[i][0] == max_l:
        total += stack[i][1]
    else: # stack[i][0] > max_l
        total += stack[i][1] * (stack[i][0] - stack[i-1][0])
print(total)
