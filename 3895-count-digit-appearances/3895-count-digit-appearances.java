class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {  int a = nums[i];
            while(a>0)
            {
                int n =a%10;
                if(n==digit) count++;
                a=a/10;

            }
        }
        return count;
    }
}