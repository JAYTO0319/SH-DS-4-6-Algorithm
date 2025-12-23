import sys

input = sys.stdin.readline

N = int(input().strip())
requests = list(map(int, input().split()))
M = int(input().strip())

# 예산 총합이 M 이하인 경우, 요청 최대값이 답
if sum(requests) <= M:
    print(max(requests))
else:
    low, high = 0, max(requests)
    answer = 0

    while low <= high:
        mid = (low + high) // 2  # 상한액 후보
        total = 0

        # 각 요청에 대해 cap 적용
        for r in requests:
            total += min(r, mid)

        # 총액이 M 이하이면 mid가 유효한 상한액
        if total <= M:
            answer = mid
            low = mid + 1
        else:
            high = mid - 1

    print(answer)
