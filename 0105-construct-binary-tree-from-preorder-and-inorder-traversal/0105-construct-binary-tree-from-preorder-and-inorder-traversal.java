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
// class Solution {
//     private TreeNode BuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
//             HashMap<Integer, Integer> map) {
//               if((preStart>preEnd)||(inStart>inEnd)) return null;
//               TreeNode root = new TreeNode(preorder[preStart]);
//               int inRoot = map.get(root.val);
//               int numsLeft = inRoot - inStart;  // gives the element left in inorder;
//               root.left = BuildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
//               root.right= BuildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
//               return root;

//     }

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             map.put(inorder[i], i);
//         }
//         TreeNode root = BuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
//         return root;
//     }
// }
class Solution {
    int inindx=0;
    int preindx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,Integer.MAX_VALUE);      
    }

    public TreeNode dfs(int[] preorder,int[] inorder, int end){
        if(preindx>=preorder.length){
            return null;
        }
        if(inorder[inindx]== end){
            inindx++;
            return null;
        }
        int val=preorder[preindx++];
        TreeNode root=new TreeNode(val);
        root.left=dfs(preorder,inorder,val);
        root.right=dfs(preorder,inorder,end);
        return root;
    }
}