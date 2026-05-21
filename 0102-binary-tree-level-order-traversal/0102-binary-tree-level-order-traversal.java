/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void order(List<List<Integer>> ans,int level,TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        if(level == ans.size())
        {
             ans.add(new ArrayList<>());
            
        }
        ans.get(level).add(root.val);
        order(ans,level+1,root.left);
        order(ans,level+1,root.right);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        order(ans,0,root);
        return ans;

        // if (root == null) {
        //     return ans;
        // }
        
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     List<Integer> level = new ArrayList<>();
            
        //     for (int i = 0; i < size; i++) {
        //         TreeNode node = q.poll();
        //         level.add(node.val);
                
        //         if (node.left != null) {
        //             q.add(node.left);
        //         }
        //         if (node.right != null) {
        //             q.add(node.right);
        //         }
        //     }
        //     ans.add(level);
        // }
        // return ans;
    }
}
