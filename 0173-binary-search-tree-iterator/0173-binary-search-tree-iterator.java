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
//  class BSTIterator {
//       private Stack<TreeNode> st = new Stack<TreeNode>();  
   
//     public BSTIterator(TreeNode root) { 
//        pushAll(root); 
//     }
    
//     public int next() {
//        TreeNode temp = st.pop();
//        pushAll(temp.right);
//        return temp.val;
//     }
    
//     public boolean hasNext() {
//         return !st.isEmpty();
//     }

//     private void pushAll(TreeNode node)
//     {
// for(; node != null; st.push(node), node = node.left);    }
// }
class BSTIterator {
    Queue<Integer> q;
    public BSTIterator(TreeNode root) {
        this.q = new LinkedList<>();
        build(root, q);
    }
    public void build(TreeNode root,Queue<Integer>q)
    {  if(root == null) return;
        build(root.left,q);
        q.offer(root.val);
        build(root.right,q);
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */