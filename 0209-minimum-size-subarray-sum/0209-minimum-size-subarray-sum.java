class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int count = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (i <= j && sum >= target) {
                count = j - i + 1;
                min = Math.min(count, min);

                sum -= nums[i];
                i++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}