// class Solution {

//     int count = 0;

//     public void sum(int start, int threshold, int k, int arr[]) {

//         if (start + k > arr.length) {
//             return;
//         }

//         int sum = 0;

//         for (int i = start; i < start + k; i++) {
//             sum += arr[i];
//         }

//         if (sum >= k * threshold) {
//             count++;
//         }

//         sum(start + 1, threshold, k, arr);
//     }

//     public int numOfSubarrays(int[] arr, int k, int threshold) {

//         sum(0, threshold, k, arr);

//         return count;
//     }
// }
// above code is recursion part

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //-------------------------------------------------------------
        // int i=0;
        // int count=0;
        // while(i<=arr.length-k)
        // {  int sum = 0;
        //     for(int j=i;j<k+i;j++)
        //     {
        //         sum+=arr[j];}
        //     if(sum>=k*threshold)
        //     {
        //         count++;
        //     }
        //  i++;
        // }
        // return count;
        // above time complexity O(n*k);

        //--------------------------Sliding Window----------------------------
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= k * threshold) {
            count++;
        }
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (sum >= k * threshold) {
                count++;
            }
        }
        return count;
    }
}