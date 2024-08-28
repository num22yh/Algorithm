def max_path_sum(triangle):
    n = len(triangle)
    # dp 배열을 삼각형과 동일한 구조로 초기화
    dp = [[0] * (i + 1) for i in range(n)]
    
    # dp 배열의 마지막 층을 삼각형의 마지막 층으로 초기화
    dp[-1] = triangle[-1][:]

    # 아래에서 위로 계산
    for i in range(n-2, -1, -1):
        for j in range(i+1):
            dp[i][j] = triangle[i][j] + max(dp[i+1][j], dp[i+1][j+1])
    
    return dp[0][0]

# 입력 받기
n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]

# 결과 출력
print(max_path_sum(triangle))
