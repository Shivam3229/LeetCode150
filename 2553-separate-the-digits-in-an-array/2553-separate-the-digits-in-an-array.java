class Solution {
    public int[] separateDigits(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int num : nums)
        {
            int divisor = 1;

            while(num / divisor >= 10)
            {
                divisor *= 10;
            }

            while(divisor > 0)
            {
                list.add(num / divisor);

                num = num % divisor;

                divisor /= 10;
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
        {
            ans[i] = list.get(i);
        }

        return ans;
    }
}