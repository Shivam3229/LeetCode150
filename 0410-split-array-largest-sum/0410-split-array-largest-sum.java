class Solution {
    public int countSubarrays(int[] nums,int maxNum){
      int k=1;
      int prev = 0;
       for(int num : nums){
        if(prev + num <= maxNum){
            prev+=num;
        }
        else{
            k++;
            prev = num;
        }
       }
       return k;
    }
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int i=0;i<nums.length;i++){
            left = Math.max(left,nums[i]);
            right += nums[i]; 
        }
        while(left <= right){
            int mid = left + (right - left)/2;
            int nk = countSubarrays(nums,mid);
            if(nk<=k){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}