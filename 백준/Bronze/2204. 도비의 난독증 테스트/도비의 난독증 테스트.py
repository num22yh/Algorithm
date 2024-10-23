import sys

while True:
    n = int(sys.stdin.readline())
    if n == 0:
        break

    arr=[]

    for _ in range(n):
        word = sys.stdin.readline().rstrip()
        arr.append(word)

    arr.sort(key= lambda x : x.lower())

    print(arr[0])
        

