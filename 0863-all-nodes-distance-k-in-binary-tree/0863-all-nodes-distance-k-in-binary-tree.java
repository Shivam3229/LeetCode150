/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root,Map<TreeNode,TreeNode> parent)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
           TreeNode current = queue.poll();
           if(current.left!=null)
           {
             parent.put(current.left,current);
             queue.offer(current.left);
           } 
           if(current.right!=null)
           {
            parent.put(current.right,current);
            queue.offer(current.right);
           }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        markParents(root,parent);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int cur_level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(cur_level == k) break;
            cur_level++;
            for(int i=0;i<size;i++)
            {
                TreeNode current = q.poll();
                if(current.left!=null && visited.get(current.left)==null)
                {
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null)
                {
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent.get(current)!=null && visited.get(parent.get(current))==null)
                {
                    q.offer(parent.get(current));
                    visited.put(parent.get(current),true);
                }
            } 
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode current = q.poll();
            result.add(current.val);
        }
        return result;
    }
}