class Solution {
    public int maxSubArray(int[] nums) {
        int s=nums[0];
        int max_s=nums[0];
        for(int i=1;i<nums.length;i++){
            s=Math.max(nums[i],s+nums[i]);
            max_s=Math.max(max_s,s);
        }
        return max_s;
    }
}