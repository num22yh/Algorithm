# 다이나믹 프로그래밍
# 메모리를 사용해서 중복 연산을 줄이고, 중복 연산을 줄여서 수행속도를 개선한다.

# 1. DFS/BFS로 풀 수는 있지만 경우의 수가 너무 많은 문제 (5*10^6 == 500만개 이상이면 dp로 풀기)
# 2. 경우의 수들에 중복적인 연산이 많은 연산

# 어떤 식으로 정보 누적해야 연산횟수를 줄일 수 있을 지가 핵심

# 각 N 에 대해 0과 1의 출력 횟수를 저장할 DP 배열을 정의
# 초기값 설정 : dp[0] = [1,0] , dp[1]=[0,1]
# 점화식 찾기 : db[N] = d[N-1]+db[N-2]


def fibonacci_count(n):
    dp = [[1,0],[0,1]]+[[0,0] for _ in range(n-1)] # dp 배열 초기화
    
    for i in range(2, n+1):
        dp[i][0] = dp[i-1][0]+dp[i-2][0]
        dp[i][1] = dp[i-1][1]+dp[i-2][1]
    
    return dp[n]


# 테스트 케이스 입력받기
T = int(input())
for _ in range(T):
    n = int(input())
    result = fibonacci_count(n)
    print(result[0], result[1])