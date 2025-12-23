import sys
input = sys.stdin.readline

n = int(input().strip())
heights = [0] * 1001

minL, maxL = 1000, 0
for _ in range(n):
    l, h = map(int, input().split())
    heights[l] = h
    if l < minL: minL = l
    if l > maxL: maxL = l

maxH = max(heights)
leftMax = next(i for i in range(minL, maxL + 1) if heights[i] == maxH)
rightMax = next(i for i in range(maxL, minL - 1, -1) if heights[i] == maxH)

area = 0

# 왼쪽 -> leftMax
cur = 0
for x in range(minL, leftMax):
    cur = max(cur, heights[x])
    area += cur

# 오른쪽 -> rightMax
cur = 0
for x in range(maxL, rightMax, -1):
    cur = max(cur, heights[x])
    area += cur

# 가운데(최고 높이 구간) 포함
area += maxH * (rightMax - leftMax + 1)

print(area)
