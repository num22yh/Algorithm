import sys
sys.setrecursionlimit(10**6) # 재귀 깊이 제한 해제

def visiting(v):
    if v not in to_visit:
        global cycle
        cycle += 1
        return cycle
    to_visit.remove(v)
    next = arr[v]
    
    visiting(next)
    
   
T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    arr = list(map(int,sys.stdin.readline().split()))
    arr.insert(0,0) 
    to_visit = [x for x in range(1,N+1)]
    cycle = 0
    while to_visit: 
        v = to_visit[0]     
        visiting(v)
    print(cycle)
