// class Solution {
//     public int findMaxLength(int[] nums) {
//         int n = nums.length;
//         int maxLen = 0;

//         for (int i = 0; i < n; i++) {
//             int sum = 0;

//             for (int j = i; j < n; j++) {
//                 if (nums[j] == 0)
//                     sum -= 1;
//                 else
//                     sum += 1;

//                 if (sum == 0) {
//                     maxLen = Math.max(maxLen, j - i + 1);
//                 }
//             }
//         }

//         return maxLen;
//     }
// }
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0)
                sum--;
            else
                sum++;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // sirf pehli occurrence store karo
            }
        }

        return maxLen;
    }
}