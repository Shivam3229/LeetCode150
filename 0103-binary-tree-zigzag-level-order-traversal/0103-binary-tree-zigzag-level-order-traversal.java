class Solution {

    public void order(List<List<Integer>> ans,
                      int level,
                      TreeNode root,
                      boolean leftToRight)
    {
        if(root == null)
        {
            return;
        }

        if(level == ans.size())
        {
            ans.add(new ArrayList<>());
        }

        if(leftToRight)
        {
            ans.get(level).add(root.val);
        }
        else
        {
            ans.get(level).add(0, root.val);
        }

        order(ans, level + 1, root.left, !leftToRight);

        order(ans, level + 1, root.right, !leftToRight);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        order(ans, 0, root, true);

        return ans;
    }
}