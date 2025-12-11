n = 1000 - int(input())          # 거스름돈
money = [500, 100, 50, 10, 5, 1] # 돈의 단위
total = 0                        # 거스름돈의 개수
for m in money:
    # 남은 거스름돈이 0원이 되면 종료
    if n == 0: break
        
    total += n // m
    n %= m
print(total)
