import sys
num = int(sys.stdin.readline().strip())

word_dict = dict()
for _ in range(num):
    word = sys.stdin.readline().strip()
    word_dict[word] = len(word)
sorted_wdict=(sorted(word_dict.items(), key=lambda x: (x[1], x[0])))
print('\n'.join(sorted_wdict[i][0] for i in range(len(sorted_wdict))))
