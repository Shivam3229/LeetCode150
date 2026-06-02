class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)
            return null;

        if(root.val == key)
        {
            // no left child
            if(root.left == null)
                return root.right;

            // no right child
            if(root.right == null)
                return root.left;

            // two children
            TreeNode temp = root.right;

            while(temp.left != null)
            {
                temp = temp.left;
            }

            root.val = temp.val;

            root.right = deleteNode(root.right, temp.val);
        }
        else if(root.val > key)
        {
            root.left = deleteNode(root.left, key);
        }
        else
        {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}