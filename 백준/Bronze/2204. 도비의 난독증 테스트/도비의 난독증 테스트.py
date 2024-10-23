import sys

while True:
    n = int(sys.stdin.readline().strip())
    if n == 0:
        break

    arr = [sys.stdin.readline().strip() for _ in range(n)]

    # 사전 순으로 정렬하되, 대소문자 구분 없이 정렬 (대소문자 무시)
    arr_sorted = sorted(arr, key=lambda x: x.lower())

    print(arr_sorted[0])