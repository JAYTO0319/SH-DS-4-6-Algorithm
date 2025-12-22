from collections import deque

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=" ")
    
    for e in graph[v]:
        if not visited[e]:
            dfs(graph, e, visited)

def bfs(graph, s, visited):
    queue = deque([s])
    visited[s] = True
    
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        
        for e in graph[v]:
            if not visited[e]:
                queue.append(e)
                visited[e] = True

# 입력받기
n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)] # 각 정점마다 연결된 노드들을 담을 리스트
visited_d = [False] * (n + 1)      # 각 정점의 방문여부를 담을 리스트
visited_b = [False] * (n + 1)

for _ in range(m):
    # 양방향 그래프이므로 양쪽에 값을 넣음
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

# dfs & bfs 수행 후 결과값 출력
dfs(graph, v, visited_d)
print()
bfs(graph, v, visited_b)
