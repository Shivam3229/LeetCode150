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
//     int inIdx;
//     int postIdx;

//     public TreeNode buildTree(int[] inorder, int[] postorder) {

//         inIdx = inorder.length - 1;
//         postIdx = postorder.length - 1;

//         return dfs(inorder, postorder, Integer.MAX_VALUE);
//     }

//     private TreeNode dfs(int[] inorder, int[] postorder, int end) {

//         if(postIdx < 0)
//             return null;

//         if(inorder[inIdx] == end) {
//             inIdx--;
//             return null;
//         }

//         int val = postorder[postIdx--];

//         TreeNode root = new TreeNode(val);

//         root.right = dfs(inorder, postorder, val);
//         root.left = dfs(inorder, postorder, end); // parent boundary set krta hain

//         return root;
//     }
// }
class Solution {
    private TreeNode BuildTree(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
            HashMap<Integer, Integer> map) {
              if((pStart<pEnd)||(iStart<iEnd)) return null;
              TreeNode root = new TreeNode(postorder[pStart]);
              int inRoot = map.get(root.val);
              int numsright = iStart - inRoot;  // gives the element left in inorder;
              root.right= BuildTree(postorder,pStart-1,pStart-numsright,inorder,iStart,inRoot+1,map);
              root.left = BuildTree(postorder,pStart-numsright-1,pEnd,inorder,inRoot-1,iEnd,map);
              return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = BuildTree(postorder,postorder.length-1,0,inorder,inorder.length-1,0,map);
        return root;
    }
}