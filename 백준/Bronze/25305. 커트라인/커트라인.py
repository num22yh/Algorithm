import sys
N, k = map(int,sys.stdin.readline().split())
scores = list(map(int,sys.stdin.readline().split())) #O(n)

scores.sort(reverse=True) #O(nlogn)
print(scores[k-1])