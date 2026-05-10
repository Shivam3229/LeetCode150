class Solution {
    public void combinations(int i,int target,int candidates[],List<Integer>current,List<List<Integer>>list)
    {
        if(target == 0)
        {
            list.add(new ArrayList<Integer>(current));
            return;
        }
        if(i==candidates.length) return;

        if(candidates[i]<=target)
        {
            current.add(candidates[i]);
            combinations(i+1,target-candidates[i],candidates,current,list);
            current.remove(current.size()-1);
        }
           while (i + 1 < candidates.length &&
               candidates[i] == candidates[i + 1]) {
            i++;
        }
        combinations(i+1,target,candidates,current,list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0,target,candidates,current,list);
        return list;
    }
}