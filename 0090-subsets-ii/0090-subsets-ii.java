class Solution {

    public void subsets(int i, int nums[],
                        List<Integer> current,
                        List<List<Integer>> ans) {

        if (i == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // include
        current.add(nums[i]);
        subsets(i + 1, nums, current, ans);

        current.remove(current.size() - 1);

        // skip duplicates
        while (i + 1 < nums.length &&
               nums[i] == nums[i + 1]) {
            i++;
        }

        // exclude
        subsets(i + 1, nums, current, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}