import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

# 실제 높이만 사용
heights = set()
for i in range(N):
    for j in range(N):
        heights.add(board[i][j])
heights.add(0)

visited = [[0]*N for _ in range(N)]
mark = 0

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(sx, sy, h):
    q = deque()
    q.append((sx, sy))
    visited[sx][sy] = mark

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny] != mark and board[nx][ny] > h:
                    visited[nx][ny] = mark
                    q.append((nx, ny))

answer = 0

for h in heights:
    mark += 1
    cnt = 0
    for i in range(N):
        for j in range(N):
            if board[i][j] > h and visited[i][j] != mark:
                bfs(i, j, h)
                cnt += 1
    answer = max(answer, cnt)

print(answer)
