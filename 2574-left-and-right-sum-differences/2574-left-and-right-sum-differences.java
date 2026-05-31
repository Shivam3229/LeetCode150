class Solution {
static {
    int[] arr = new int[10000];
    for(int i = 0; i < arr.length; i++) {
        arr[i] = i;
    }
}
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int total = 0;
        for(int num : nums) {
            total += num;
        }

        int leftSum = 0;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            total -= nums[i];   
            ans[i] = Math.abs(leftSum - total);

            leftSum += nums[i];
        }

        return ans;
    }
}