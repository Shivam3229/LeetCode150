// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int result[] = new int[nums1.length];

//         for (int i = 0; i < nums1.length; i++) {
//             int top = -1;
//             for (int j = 0; j < nums2.length; j++) {
//                 if (nums1[i] == nums2[j]) {
//                     top = j;
//                     break;
//                 }
//             }
//         int nextGreater = -1;
//             for (int j = top + 1; j < nums2.length; j++) {
//                 if (nums2[j] > nums1[i]) {
//                     nextGreater = nums2[j];
//                     break;
//                 }
//             }

//             result[i] = nextGreater;
//         }

//         return result;
//     }
// }
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Process nums2
        for (int num : nums2) {
            while (!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        // Step 2: Remaining elements → no greater element
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Step 3: Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}