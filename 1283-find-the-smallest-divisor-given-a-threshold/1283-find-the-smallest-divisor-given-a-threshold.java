// class Solution {
//     public int smallestDivisor(int[] nums, int threshold) {
//         Arrays.sort(nums);
//         int range = nums[nums.length - 1];
//         for (int i = 1; i <= range; i++) {
//             int sum = 0;
//             for (int j = 0; j < nums.length; j++) {
//                 int n = (nums[j] + i - 1) / i;
                
//                 sum+=n;
//             }
//             if (sum <= threshold) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int sum = 0;

            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }

            if (sum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}