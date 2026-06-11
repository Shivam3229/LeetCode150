class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j =0;
        int sum = 0;
        int max = 0;
        while(j < nums.length)
        {
            sum += nums[j];
            if(nums[j]==0)
            {
                sum = 0;
                i=j;
            }
            else
            {
                max = Math.max(sum,max);
            }
        j++;
        }
        return max;
    }
}