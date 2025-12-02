# BOJ 4949 - 균형잡힌 세상(for 유나)
# 개인 풀이 기록
# - 괄호의 개수만 맞추는 문제가 아니라,
#   열린 괄호와 닫힌 괄호의 '순서'가 올바른지 확인해야 하는 문제.
# - 마지막에 열린 괄호부터 차례로 닫혀야 하므로 스택(LIFO) 구조를 사용한다.

while True:
    sentence = input().rstrip()

    # 입력이 '.' 이면 종료
    if sentence == '.':
        break

    stack = []  # 열려 있는 괄호를 보관할 스택
    is_valid = True  # 문자열의 균형 여부를 표시(중간에 틀리면 False)

    for ch in sentence:

        # 1) 열린 괄호는 스택에 그대로 넣기
        if ch == '(' or ch == '[':
            stack.append(ch)

        # 2) 닫는 괄호의 경우: 스택에서 마지막 열린 괄호와 짝이 맞는지 확인
        elif ch == ')':
            # 스택이 비어있거나 마지막 열린 괄호가 '('이 아니면 균형 깨짐
            if not stack or stack[-1] != '(':
                is_valid = False
                break
            stack.pop()  # 올바르게 짝이 맞으면 제거

        elif ch == ']':
            if not stack or stack[-1] != '[':
                is_valid = False
                break
            stack.pop()

        # 그 외 문자는 균형 판단에 영향 없음 → 무시
        else:
            continue

    # 모든 문자를 처리한 후,
    # 1) 중간에 짝이 깨졌는지
    # 2) 스택에 열린 괄호가 남아있는지
    # 두 조건을 모두 확인해야 함
    if is_valid and not stack:
        print("yes")
    else:
        print("no")
