N = int(input())

dp=[0]*(N+1)


for n in range(N+1):
    if n==0 or n == 1:
        dp[n] = 0
    else :

        dp[n] = 1+dp[n-1]
    
        if n%2 == 0 :
            dp[n]= min(dp[n], 1+dp[n//2])
        if n%3 == 0 :
            dp[n]= min(dp[n], 1+dp[n//3])
            
    
print(dp[N])