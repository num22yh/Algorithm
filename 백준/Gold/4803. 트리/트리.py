import sys
from collections import deque

T = 1

# 3. 해당 연결요소가 사이클인지 트리인지 판단하는 탐색을 구현합니다.
def bfs(x):
    flag = True
    q = deque()
    q.append(x)
    while q:
        now = q.popleft()
        if visited[now]:
            flag = False
        visited[now] = True
        for j in graph[now]:
            if not visited[j]:
                q.append(j)
    return flag

while True:
    # 1. 문제의 input을 인접 리스트 형태로 받습니다.
    n, m = map(int, sys.stdin.readline().split())
    if n == 0 and m == 0:
        break
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        x, y = map(int, sys.stdin.readline().split())
        graph[x].append(y)
        graph[y].append(x)

    # 2. 탐색을 위한 초기 값을 설정합니다.
    ans = 0
    visited = [False for _ in range(n+1)]
    for i in range(1, n+1):
        # 4. 방문하지 않은 노드가 발견되면 새로운 연결요소로 판단해 트리인지 탐색을 진행합니다.
        if not visited[i] and bfs(i):
            ans += 1
    
    # 5. 문제의 조건에 맞게 정답을 출력합니다.
    if ans == 0:
        print('Case {}: No trees.'.format(T))
    elif ans == 1:
        print('Case {}: There is one tree.'.format(T))
    else:
        print('Case {}: A forest of {} trees.'.format(T, ans))

    T += 1

