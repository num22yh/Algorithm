import sys

N = int(sys.stdin.readline())
people = [[] for _ in range(N+1)] # people[0]에는 []저장

for i in range(1,N+1):
    cards = list(map(int,sys.stdin.readline().split()))
    people[i] = cards


def max_combination(list):
    max = 0 #만들 수 있는 제일 큰 일의 자리 숫자
    for i in range(0,3):
        for j in range(i+1,4):
            for k in range(j+1,5):
                result = (list[i]+list[j]+list[k])%10
                if result >= max:
                    max = result
    
    return max

max_person = 0
max_result = 0

for i in range(1,N+1):
    result = max_combination(people[i])
    
    if result >= max_result:
        max_result = result
        max_person = i

print(max_person)