class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(checksum(nums[i]) == i)
                return i;
        }

        return -1;
    }

    public int checksum(int num){
        int sum = 0;

        while(num != 0){
            sum = sum + num % 10;
            num /= 10;
        }

        return sum;
    }
}