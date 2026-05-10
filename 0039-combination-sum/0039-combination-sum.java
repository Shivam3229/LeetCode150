class Solution {

    public void real(int i, int target, int[] candidates,
            List<Integer> current,
            List<List<Integer>> ans) {

        
        if (target == 0) {
            ans.add(new ArrayList<>(current));// a way to add list into a list
            return;
        }

       
        if (i == candidates.length) {
            return; // just reach the last element
        }

        
        if (candidates[i] <= target) {

            current.add(candidates[i]);//add
            real(i, target - candidates[i], candidates, current, ans);//explore
            current.remove(current.size() - 1);// backtrack
        }

    
        real(i + 1, target, candidates, current, ans); // skip part
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        real(0, target, candidates, current, ans);

        return ans;
    }
}