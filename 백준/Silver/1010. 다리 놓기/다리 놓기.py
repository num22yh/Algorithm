dp = [[0]*30 for i in range(30)]

# N = 1일 때 초기화
for m in range(30):
    dp[1][m] = m

# N = 2 이상일 때 계산
for n in range(2,30):
    for m in range(n,30):
        if n==m:
            dp[n][m]=1
        else:
            dp[n][m] = dp[n][m-1] + dp[n-1][m-1]

#Test case 입력받고 경우의 수 출력하기
import sys
T = int(sys.stdin.readline())
for _ in range(T):
    N, M = map(int,sys.stdin.readline().split())
    print(dp[N][M])