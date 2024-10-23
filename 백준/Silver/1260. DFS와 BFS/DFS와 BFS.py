import sys
from collections import deque

N, M, V = map(int,sys.stdin.readline().split())

graph = {i:[] for i in range(N+1)}

for _ in range(M):
    a , b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N+1):
    graph[i].sort()

def dfs(start_v, visited=[]):
    cur_v = start_v
    visited.append(cur_v)
    for next_v in graph[cur_v]:
        if next_v not in visited:
            visited = dfs(next_v, visited)
    
    return visited

def bfs(start_v, visited =[]):
    visited.append(start_v)
    queue = deque([start_v])
    while queue:
        cur_v = queue.popleft()
        for next_v in graph[cur_v]:
            if next_v not in visited:
                visited.append(next_v)
                queue.append(next_v)
    
    return visited

result_dfs = dfs(V)
result_bfs = bfs(V)

print(" ".join(map(str,result_dfs)))
print(" ".join(map(str,result_bfs)))