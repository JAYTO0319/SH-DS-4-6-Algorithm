import sys
from collections import deque

input = sys.stdin.readline

# 정점 수 N, 간선 수 M 입력
N = int(input().rstrip())
M = int(input().rstrip())

# 인접 리스트 생성
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 방문 체크 배열
visited = [False] * (N+1)

# BFS or DFS 가능 → 여기서는 DFS(재귀) 사용
def dfs(node):
    visited[node] = True
    count = 0
    for nxt in graph[node]:
        if not visited[nxt]:
            count += 1 + dfs(nxt)
    return count

# 1번부터 전파 시작
result = dfs(1)
print(result)
