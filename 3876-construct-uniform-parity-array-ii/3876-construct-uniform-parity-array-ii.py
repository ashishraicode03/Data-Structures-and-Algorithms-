class Solution:
    def uniformArray(self, nums1: List[int]) -> bool:
        mn = min(nums1)
        count = sum(1 for x in nums1 if x % 2 == 1)

        return mn % 2 == 1 or count == 0