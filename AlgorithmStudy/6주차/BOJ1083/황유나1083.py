# 최대 교환 가능 횟수(S)만큼 리스트를 잘라서
# 그 안에서 현재값과 최대값과 교체
# 교환 일어난 만큼 횟수 차감
# -> 횟수가 0이 될 때까지 위 과정 반복

n = int(input())
num = list(map(int, input().split()))
s = int(input())
result = [] # 결과: 사전 순 정렬 시 제일 큰 리스트

while s > 0:
    # 최대 교환 가능 횟수(S)만큼 리스트를 자름
    end = min(s + 1, len(num))

    # 리스트 내 원소가 하나이면 종료
    if end == 1:
        break
    
    # 리스트 내 최대값 찾기
    max_i = 0        # 리스트 내 최대값의 위치
    max_v = num[0]  # 리스트 내 최대값
    for j in range(1, end):
        if max_v < num[j]:
            max_i = j
            max_v = num[j]

    # 최대값을 현재 위치로
    num.pop(max_i) # 최대값 제거 후
    result.append(max_v) # 결과 리스트에 추가
    s -= max_i # 교환 가능 횟수 차감

result.extend(num)
print(*result)
