class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0;
        int j=0;
        double sum = 0.0;
        double avg = Double.NEGATIVE_INFINITY;
        while(j<nums.length)
        {
            sum += nums[j];
            if(j-i+1 == k)
            {
                avg = Math.max(avg,sum/k);
                sum -= nums[i];
                i++;
            }
           j++;
        }
        return avg;
    }
}