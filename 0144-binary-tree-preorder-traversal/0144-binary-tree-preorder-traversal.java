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
    public void preorderTr( List<Integer> preorder,TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        preorder.add(node.val);
        preorderTr(preorder,node.left);
        preorderTr(preorder,node.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorderTr(preorder,root);
        return preorder;
    }
}