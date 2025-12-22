import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())

n_dic = {i: [] for i in range(1, n+1)}

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    n_dic[a].append(b)
    n_dic[b].append(a)

for key in n_dic:
    n_dic[key].sort()

# DFS
visited_dfs = {i: False for i in range(1, n+1)}

def dfs(node):
    visited_dfs[node] = True
    print(node, end=' ')
    
    for next_node in n_dic[node]:
        if not visited_dfs[next_node]:
            dfs(next_node)

dfs(v)
print()

# BFS
def bfs(start):
    visited = {i: False for i in range(1, n+1)}
    visited[start] = True
    q = deque([start])
    result = []

    while q:
        node = q.popleft()
        result.append(node)

        for next_node in n_dic[node]:
            if not visited[next_node]:
                visited[next_node] = True
                q.append(next_node)

    return ' '.join(map(str, result))

print(bfs(v))
