# 입력 처리
n = int(input())  # 컴퓨터의 수 (정점의 개수)
m = int(input())  # 연결된 쌍의 수 (간선의 개수)


graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


visited = [False] * (n + 1)


def dfs(v):
    visited[v] = True
    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(neighbor)


dfs(1)

print(visited.count(True) - 1)
