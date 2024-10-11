S = input()
alphabets = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
count = [0 for x in range(26)]

for alphabet in S: # O(n)
    count[alphabets.index(alphabet)] += 1 #alphabets.index(alphabet) : O(26) , count[인덱스]로 찾기 -> O(1)

for x in count:
    print(x,end=" ")