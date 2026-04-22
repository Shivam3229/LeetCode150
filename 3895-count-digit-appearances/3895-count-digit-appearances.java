// class Solution {
//     public int countDigitOccurrences(int[] nums, int digit) {
//         int count = 0;
//         for(int i=0;i<nums.length;i++)
//         {  int a = nums[i];
//             while(a>0)
//             {
//                 int n =a%10;
//                 if(n==digit) count++;
//                 a=a/10;

//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;

        for (int num : nums) {
            num = Math.abs(num); // handle negatives

            // Special case: if number is 0
            if (num == 0 && digit == 0) {
                count++;
                continue;
            }

            while (num > 0) {
                if (num % 10 == digit) {
                    count++;
                }
                num /= 10;
            }
        }

        return count;
    }
}