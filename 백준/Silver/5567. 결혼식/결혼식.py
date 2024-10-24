import sys
from collections import deque
sys.setrecursionlimit(10**6)

n = int(sys.stdin.readline()) # 동기의 수
m = int(sys.stdin.readline()) # 간선의 수 == 관계의 수

graph = {i:[] for i in range(n+1)} # 0~ n

for _ in range(m):
    a, b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs(start,depth,visited=[]):
    visited.append(start)
    queue = deque()
    queue.append((start,depth)) # 다음에 방문할 곳 예약

    while queue: 
        cur_v, cur_depth = queue.popleft() # 실제로 방문
        if cur_depth == 2:
            break
        for next_v in graph[cur_v]:
            if next_v not in visited:
                queue.append((next_v,cur_depth+1))
                visited.append(next_v)
                
                
                    
                
    return visited

result = bfs(1,0)
print(len(result)-1)