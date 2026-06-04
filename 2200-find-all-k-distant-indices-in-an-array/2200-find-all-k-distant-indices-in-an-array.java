// class Solution {
//     public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
//         List<Integer> ans = new ArrayList<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             for(int j=0;j<nums.length;j++){
//                 if(Math.abs(i-j)<=k && nums[j]==key)
//                 {
//                     ans.add(i);
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> ans = new ArrayList<>();
        int start = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == key) {

                int left = Math.max(start, j - k);
                int right = Math.min(nums.length - 1, j + k);

                for (int i = left; i <= right; i++) {
                    ans.add(i);
                }

                start = right + 1;
            }
        }

        return ans;
    }
}