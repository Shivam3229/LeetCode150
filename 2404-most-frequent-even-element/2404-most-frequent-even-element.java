// class Solution {
//     public int mostFrequentEven(int[] nums) {
//         int result = -1;
//         int maxFreq = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] % 2 != 0) continue;

//             int count = 0;
//             for (int j = 0; j < nums.length; j++) {
//                 if (nums[i] == nums[j]) count++;
//             }

//             if (count > maxFreq || (count == maxFreq && nums[i] < result)) {
//                 maxFreq = count;
//                 result = nums[i];
//             }
//         }

//         return result;
//     }
// }
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int maxFreq = 0;
        int result = -1;

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq > maxFreq || (freq == maxFreq && key < result)) {
                maxFreq = freq;
                result = key;
            }
        }

        return result;
    }
}