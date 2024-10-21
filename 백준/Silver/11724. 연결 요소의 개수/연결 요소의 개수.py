import sys
sys.setrecursionlimit(10**6)

N, M = map(int,sys.stdin.readline().split())

# 그래프를 딕셔너리로 초기화
graph={i:[] for i in range(1,N+1)}

for _ in range(M):
    u, v = map(int,sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

visited=[False for _ in range(N+1)]
count = 0

def dfs(start_v,graph):
    cur_v = start_v
    visited[cur_v] = True
    for v in graph[cur_v]:
        if visited[v] == False:
            next_v = v
            dfs(next_v,graph)
    return

for key in graph.keys():
    if visited[key]==False:
        count+=1
        dfs(key,graph)
    else:
        continue

print(count)