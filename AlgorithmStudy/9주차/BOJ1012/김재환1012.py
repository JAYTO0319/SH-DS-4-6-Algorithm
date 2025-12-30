import sys
from collections import deque

input = sys.stdin.readline

# 상하좌우 이동 방향
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input().strip())
for _ in range(T):
    # M: 가로 길이, N: 세로 길이, K: 배추 개수
    M, N, K = map(int, input().split())

    # 배추 위치 표시 배열: 0 = 없음, 1 = 있음
    field = [[0]*M for _ in range(N)]
    for __ in range(K):
        x, y = map(int, input().split())
        field[y][x] = 1

    # 방문 체크
    visited = [[False]*M for _ in range(N)]

    def bfs(sr, sc):
        queue = deque()
        queue.append((sr, sc))
        visited[sr][sc] = True

        while queue:
            r, c = queue.popleft()
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                # 범위 체크
                if 0 <= nr < N and 0 <= nc < M:
                    # 배추 있고 아직 방문 안 했으면
                    if field[nr][nc] == 1 and not visited[nr][nc]:
                        visited[nr][nc] = True
                        queue.append((nr, nc))

    # 군집 수 세기
    count = 0
    for r in range(N):
        for c in range(M):
            if field[r][c] == 1 and not visited[r][c]:
                # 새 연결 요소 발견
                bfs(r, c)
                count += 1

    print(count)
