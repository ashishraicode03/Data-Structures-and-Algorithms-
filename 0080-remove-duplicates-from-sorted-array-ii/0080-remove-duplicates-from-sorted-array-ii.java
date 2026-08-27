class Solution {

    public int removeDuplicates(int[] nums) {

        // Arrays with at most two elements already satisfy the condition.
        if (nums.length <= 2)
            return nums.length;

        // Points to the position where the next valid element should be written.
        int insertIndex = 2;

        for (int currentIndex = 2;
             currentIndex < nums.length;
             currentIndex++) {
                
            if (nums[currentIndex] != nums[insertIndex - 2])
                nums[insertIndex++] = nums[currentIndex];
        }

        return insertIndex;
    }
}