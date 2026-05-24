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
 // diameter = 1+right subtree + left subtree
class Solution {

    int diameter = 0;

    public int height(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }
}
// class Solution {

//     public int diameterOfBinaryTree(Node root) {

//         int[] diameter = new int[1];

//         height(root, diameter);

//         return diameter[0];
//     }

//     private int height(Node node, int[] diameter) {

//         if (node == null) {
//             return 0;
//         }

//         int lh = height(node.left, diameter);
//         int rh = height(node.right, diameter);

//         diameter[0] = Math.max(diameter[0], lh + rh);

//         return 1 + Math.max(lh, rh);
//     }
// }
