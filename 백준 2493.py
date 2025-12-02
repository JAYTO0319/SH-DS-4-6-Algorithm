import sys
input = sys.stdin.readline

# ---------------------- 입력 처리 ----------------------
N = int(input().rstrip())
heights = list(map(int, input().split()))

# ---------------------- 자료구조 선택 & 이유 ----------------------
# 탑 개수 최대 500,000 → O(N^2) 탐색은 무조건 불가.
# 각 탑마다 “왼쪽에서 자신보다 높거나 같은 탑 중 가장 가까운 것”을 찾아야 함.
# 이런 유형은 스택을 활용한 '모노톤 스택' 방식이 가장 적합.
# 스택에는 중요한 후보 탑만 유지하고, 의미없어진 낮은 탑은 제거한다.

stack = []  # 스택 요소: (탑번호(index 1-based), 탑 높이)
res = [0] * N  # 결과 저장 리스트, 기본값 0

# ---------------------- 메인 로직 ----------------------
for i in range(N):
    current_height = heights[i]
    current_idx = i + 1  # 문제에서 탑 번호는 1부터 시작

    # 스택에서 의미 없는 탑 제거: 현재 탑보다 낮은 탑은 더이상 신호 수신자로 적합치 않음
    while stack and stack[-1][1] < current_height:
        stack.pop()

    # 이제 스택이 비어있으면 수신 탑 없음 → 0
    if not stack:
        res[i] = 0
    else:
        # 스택의 top이 현재 탑보다 높거나 같음 → 이 탑이 수신 탑
        res[i] = stack[-1][0]

    # 현재 탑을 스택에 후보로 추가
    stack.append((current_idx, current_height))

# ---------------------- 출력 ----------------------
# 공백 하나로 구분해서 한 줄 출력
print(" ".join(map(str, res)))
