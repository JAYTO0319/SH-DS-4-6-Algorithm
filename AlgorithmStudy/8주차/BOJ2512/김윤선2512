#랜선 자르기와 비슷한 느낌?
#정해진 숫자 안에서 가능한 최대로 금액 구하기
#최소 예산~최대 예산까지 이분 탐색
#탐색한 결과 값이 각 지방의 예산보다 크거나 같은지 확인
#결과보다 지방예산이 크면 탐색한 결과로 설정하고 합계 확인
#
import sys

n = int(sys.stdin.readline().strip())

b_list = list(map(int, sys.stdin.readline().strip().split(" ")))

b_list.sort()

c_budget = int(sys.stdin.readline().strip())

#가장 적은 예산
start = b_list[0] if c_budget//n>b_list[0] else c_budget//n
#가장 큰 예산
end = b_list[-1]

m = 0
while start <= end:
    total = 0
    mid = (start+end)//2
    
    for i in b_list:
        if i > mid:
            total+= mid
        else:
            total +=i
    if total<= c_budget:
        m = mid
        start = mid+1
    else:
        end = mid-1
if b_list[-1]<m:
    print(b_list[-1])
else:
    print(m)
