from collections import deque

n, m = map(int, input().split())
miro = []
for _ in range(n):
    miro.append(list(map(int, input())))

move = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 현재 위치에서 이동가능한 상대 좌표
visited = [[0] * m for _ in range(n)]     # 각 좌표에 도달하기 위한 최소값 (0은 미방문)

queue = deque([(0, 0)])
visited[0][0] = 1
while queue:
    x, y = queue.popleft()
    for dx, dy in move:
        # 이동 후 좌표가 미로를 벗어나지 않고, 이동할 수 있는 칸(1)이며, 미방문(0)인 경우에만 탐색
        nx = x + dx
        ny = y + dy
        if nx >= 0 and nx < n and ny >= 0 and ny < m and miro[nx][ny] == 1 and visited[nx][ny] == 0:
            queue.append((nx, ny))
            visited[nx][ny] = visited[x][y] + 1

print(visited[n - 1][m - 1])
