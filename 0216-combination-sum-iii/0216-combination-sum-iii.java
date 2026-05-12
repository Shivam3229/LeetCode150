class Solution {
    public void sum(int i,int target,List<Integer> current,List<List<Integer>> ans,int k)
    {
        if(target == 0 && current.size()==k) // update the ans
        {
            ans.add(new ArrayList<>(current));
            return;
        }
           if (i > 9 || target < 0 || current.size() > k) { // stopping condition
            return;
        }

        if(i<=target) // step to include the element 
        {
            current.add(i);
            sum(i+1,target-i,current,ans,k);
            current.remove(current.size()-1);
        }
         sum(i + 1,target, current, ans,k);// exclude the element
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
       
        sum(1,n,current,ans,k);
        return ans;
    }
}