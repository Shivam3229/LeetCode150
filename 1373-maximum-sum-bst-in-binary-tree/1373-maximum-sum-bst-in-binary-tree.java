class NodeValue {
    int minNode;
    int maxNode;
    int sum;

    NodeValue(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}

class Solution {

    int ans = 0;

    private NodeValue largestSubTree(TreeNode root) {

        if (root == null) {
            return new NodeValue(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }

        NodeValue left = largestSubTree(root.left);
        NodeValue right = largestSubTree(root.right);

        if (left.maxNode < root.val &&
            root.val < right.minNode) {

            int currSum = left.sum + right.sum + root.val;

            ans = Math.max(ans, currSum);

            return new NodeValue(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                currSum
            );
        }

        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0
        );
    }

    public int maxSumBST(TreeNode root) {
        largestSubTree(root);
        return ans;
    }
}