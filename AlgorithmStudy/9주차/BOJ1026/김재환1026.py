import sys
input = sys.stdin.readline

# N: 배열 길이
N = int(input().strip())

# A: 재배열 가능한 배열
A = list(map(int, input().split()))

# B: 문제 설명상 재배열하면 안 되는 배열
# 하지만 "최소 합"을 계산하는 데는,
# B의 값들을 어떤 순서로 대응시키는지가 중요할 뿐,
# B 자체를 출력하거나 인덱스를 실제로 바꿔 제출하는 게 아니다.
B = list(map(int, input().split()))

# 핵심 그리디:
# 1) A는 작은 값부터
# 2) B는 큰 값부터
# 이렇게 1:1로 곱해 더하면 전체 합이 최소가 된다.
A.sort()
B.sort(reverse=True)

# 최소 합 계산
# (A[i]는 작은 것부터, B[i]는 큰 것부터 매칭)
ans = 0
for i in range(N):
    ans += A[i] * B[i]

print(ans)
