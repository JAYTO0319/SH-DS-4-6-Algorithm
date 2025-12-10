doc = input()
word = input()

i = 0         # 문서에서 탐색할 인덱스
j = len(word) # 찾을 단어의 길이
count = 0     # 단어 등장 횟수
while i < len(doc):
    cur_word = doc[i:i+j]
    if cur_word == word:
        count += 1
        i += j
    else:
        i += 1

print(count)
