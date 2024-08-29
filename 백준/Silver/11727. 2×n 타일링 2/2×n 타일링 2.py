def count_tilings(n):
    # 기본 경우 설정
    if n == 1:
        return 1
    elif n == 2:
        return 3
    
    # DP 배열 초기화
    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 3

    # DP 점화식 계산
    for i in range(3, n + 1):
        # 먼저 가로에 1을 배치하는 경우 (2x1 타일 하나를 사용)
        dp[i] = dp[i - 1]
        
        # 가로에 2를 배치하는 경우
        # 2x1 타일 두 개를 배치하거나 2x2 타일 하나를 배치할 수 있으므로 경우의 수에 2를 곱해줌
        dp[i] += 2 * dp[i - 2]
    
    return dp[n]

# 입력 받기
n = int(input())
print(count_tilings(n)%10007)