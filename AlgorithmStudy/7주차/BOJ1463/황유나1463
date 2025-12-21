n = int(input())
INF = 10 ** 6 + 1
cnt = [INF] * (n + 1)
cnt[0], cnt[1] = 0, 0

# Bottom-up 방식으로 기존값과 새로운 값 중 최소값으로 초기화
for i in range(1, n):
    if i * 3 <= n:
        cnt[i * 3] = min(cnt[i * 3], cnt[i] + 1)
    if i * 2 <= n:
        cnt[i * 2] = min(cnt[i * 2], cnt[i] + 1)
    if i + 1 <= n:
        cnt[i + 1] = min(cnt[i + 1], cnt[i] + 1)

print(cnt[n])
