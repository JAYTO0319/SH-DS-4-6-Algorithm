from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

maze = [list(map(int, input().strip())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

def bfs():
    q = deque()
    q.append((0, 0, 1))   # x, y, 거리
    visited[0][0] = True

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while q:
        x, y, dist = q.popleft()

        if x == n - 1 and y == m - 1:
            return dist

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and maze[nx][ny] == 1:
                    visited[nx][ny] = True
                    q.append((nx, ny, dist + 1))

    return -1

print(bfs())
