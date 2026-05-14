class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> map = new ArrayList<>();
        for( int i=0;i<nums.length;i++)
        {
            String n = Integer.toString(nums[i]);
            for(int j=0;j<n.length();j++)
            {
               char ch = n.charAt(j);
               int num = ch-'0';
               map.add(num);
            }

        }
        int ar[] = new int [map.size()];
        for(int i=0;i<ar.length;i++)
        {
            ar[i] = map.get(i);
        }
        return ar;
    }
}