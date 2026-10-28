class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        dp = [{0}] + [set() for _ in range(len(grid[0]) - 1)]  
        for row in grid:
            for j, v in enumerate(row):
                dp[j] = {x ^ v for x in dp[j] | (dp[j - 1] if j else set())} 
        return min(dp[-1])