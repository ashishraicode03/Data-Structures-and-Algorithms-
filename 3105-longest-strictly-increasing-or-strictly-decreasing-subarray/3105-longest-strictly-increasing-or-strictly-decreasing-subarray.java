class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int increasing = 1, decreasing = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing = increasing + 1;
                decreasing = 1;
            } else if (nums[i] < nums[i - 1]) {
                decreasing = decreasing + 1;
                increasing = 1;
            } else {
                increasing = 1;
                decreasing = 1;
            }
            int x = (increasing > decreasing) ? increasing : decreasing;
            maxLength = (maxLength > x) ? maxLength : x;
        }
        return maxLength;
    }
}