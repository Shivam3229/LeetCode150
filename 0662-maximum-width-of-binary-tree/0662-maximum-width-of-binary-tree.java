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
   public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int maxx = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty())
        {
            int size  = q.size();
            int levelmin = q.peek().num;
            int firstIndex = 0,lastIndex = 0;
            for(int i=0;i<size;i++)
            {
                int cur_index=q.peek().num-levelmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) firstIndex = cur_index;
                if(i==size-1) lastIndex = cur_index;
                if(node.left != null)
                 q.offer(new pair(node.left,cur_index*2+1));
                if(node.right != null)
                q.offer(new pair(node.right,cur_index*2+2));
            }
         maxx = Math.max(maxx,lastIndex-firstIndex+1);
        }
        return maxx;
    }
}
class pair
{
    int num;
    TreeNode node;
    pair(TreeNode node,int num)
    {
       this.num = num;
       this.node = node;
    }
}