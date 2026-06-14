class Solution {

    private int count(int[] nums, int bound) {
        int ans = 0;
        int len = 0;

        for (int num : nums) {
            if (num <= bound) {
                len++;
            } else {
                len = 0;
            }

            ans += len;
        }

        return ans;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }
}