class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] seen = new boolean[10001];
        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            while (seen[nums[right]]) {
                seen[nums[left]] = false;
                sum -= nums[left];
                left++;
            }

            seen[nums[right]] = true;
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}