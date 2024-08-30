def max_increasing_sum(arr):
    # 배열의 길이를 n에 저장
    n = len(arr)
    
    # dp 테이블 초기화: 각 인덱스에 해당하는 값은 0으로 시작
    dp = [0] * n
    
    # 모든 원소에 대해 가장 큰 증가 부분 수열 합을 구하기
    for i in range(n):
        # dp[i]는 현재 원소 arr[i]를 포함하는 가장 큰 증가 부분 수열의 합으로 초기화
        dp[i] = arr[i]
        
        # 현재 원소 이전의 원소들을 모두 확인
        for j in range(i):
            # 이전 원소가 현재 원소보다 작은 경우에만 증가 부분 수열이 가능
            if arr[j] < arr[i]:
                # dp[i] 값을 갱신: 이전 원소를 포함한 최대 합(dp[j] + arr[i])과 현재 값(dp[i]) 중 큰 값을 선택
                dp[i] = max(dp[i], dp[j] + arr[i])
    
    # 모든 dp 값 중 가장 큰 값을 반환: 가장 큰 증가 부분 수열의 합
    return max(dp)

# 입력 처리
n = int(input())
arr = list(map(int, input().split()))
print(max_increasing_sum(arr))
