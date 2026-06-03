class Solution {
    public int findMiddleIndex(int[] nums) {

        int n = nums.length;
        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for(int i = 0; i < n; i++) {

            int leftSum = (i == 0) ? 0 : prefix[i - 1];

            int rightSum = totalSum - prefix[i];

            if(leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}