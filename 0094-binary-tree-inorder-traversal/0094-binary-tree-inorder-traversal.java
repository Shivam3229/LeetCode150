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
    public void inorderTr(TreeNode root,List<Integer> inorder)
    {
        if(root == null)
        {
            return;
        }
        inorderTr(root.left,inorder);
        inorder.add(root.val);
        inorderTr(root.right,inorder);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTr(root,inorder);
        return inorder;
    }
}