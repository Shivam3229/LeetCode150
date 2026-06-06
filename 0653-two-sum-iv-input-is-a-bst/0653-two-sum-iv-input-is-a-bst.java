class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse;

    BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);

            if (reverse)
                node = node.right;
            else
                node = node.left;
        }
    }

    int next() {
        TreeNode node = st.pop();

        if (reverse)
            pushAll(node.left);
        else
            pushAll(node.right);

        return node.val;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == k)
                return true;
            else if (sum < k)
                i = left.next();
            else
                j = right.next();
        }

        return false;
    }
}