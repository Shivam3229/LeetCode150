class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        int k = n;
       for(int i=0;i<m+n;i++)
        {
            if(nums1[i]==0 && k>0)
            {
                nums1[i] = nums2[j];
                j++;
                k--;
            }


        }
        Arrays.sort(nums1);
        for(int i=0;i<m+n;i++)
        {
            System.out.print(nums1[i]);
            
        }
        
    }
}