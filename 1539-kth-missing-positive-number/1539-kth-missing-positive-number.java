class Solution {
    public int findKthPositive(int[] arr, int k) {
        // int missing  = 0;
        int left  = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                left = mid+1;
            }
            else{
                right = mid-1;
            }

        }
        return left + k;
    }
}
//  Intituion : numbers Start with 1 and if the position is granted by another number so you wl get to know that how are already missing