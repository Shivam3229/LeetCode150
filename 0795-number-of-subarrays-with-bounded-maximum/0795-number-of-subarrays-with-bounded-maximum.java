// class Solution {

//     private int count(int[] nums, int bound) {
//         int ans = 0;
//         int len = 0;

//         for (int num : nums) {
//             if (num <= bound) {
//                 len++;
//             } else {
//                 len = 0;
//             }

//             ans += len;
//         }

//         return ans;
//     }

//     public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//         return count(nums, right) - count(nums, left - 1);
//     }
// }
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int lastGreater = -1; // Last index where nums[i] > right
        int lastValid = -1;   // Last index where nums[i] >= left

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > right) {
                lastGreater = i;
            }

            if (nums[i] >= left) {
                lastValid = i;
            }

            ans += Math.max(0, lastValid - lastGreater);
        }

        return ans;
    }
}