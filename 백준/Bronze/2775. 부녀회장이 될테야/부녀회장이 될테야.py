# 배열 초기화
arr = [[0]*15 for _ in range(15)]

# 0층 초기화
for n in range(15):
    arr[0][n]=n

# 1층 ~ 14층 계산

for current_stair in range(1,15):
    people = 0 # 거주민 수

    for current_ho in range(1,15):
        people += arr[current_stair-1][current_ho]
        arr[current_stair][current_ho] = people
        


import sys

T = int(sys.stdin.readline())
for case in range(T):
   k = int(sys.stdin.readline())
  
   n = int(sys.stdin.readline())
   print(arr[k][n])
