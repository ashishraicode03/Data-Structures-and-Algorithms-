from math import gcd
from collections import defaultdict

class Solution:
    def maxPoints(self, points):
        n = len(points)
        if n <= 2: return n
        ans = 2
        for i in range(n):
            slope_map = defaultdict(int)
            for j in range(i + 1, n):
                dx = points[j][0] - points[i][0]
                dy = points[j][1] - points[i][1]
                g = gcd(abs(dx), abs(dy))
                dx //= g; dy //= g
                if dx < 0: dx, dy = -dx, -dy
                elif dx == 0: dy = abs(dy)
                slope_map[(dx, dy)] += 1
                ans = max(ans, slope_map[(dx, dy)] + 1)
        return ans