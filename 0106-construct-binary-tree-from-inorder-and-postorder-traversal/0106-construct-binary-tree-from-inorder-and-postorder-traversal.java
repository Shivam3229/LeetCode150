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
    int inIdx;
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        inIdx = inorder.length - 1;
        postIdx = postorder.length - 1;

        return dfs(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int end) {

        if(postIdx < 0)
            return null;

        if(inorder[inIdx] == end) {
            inIdx--;
            return null;
        }

        int val = postorder[postIdx--];

        TreeNode root = new TreeNode(val);

        root.right = dfs(inorder, postorder, val);
        root.left = dfs(inorder, postorder, end);

        return root;
    }
}