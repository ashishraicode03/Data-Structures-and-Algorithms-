class Solution {
    int count = 0;
    TreeNode result = null;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result.val;
    }

    private void helper(TreeNode node, int k) {
        if (node == null) return;

        helper(node.left, k);       // Traverse left
        count++;                    // Visit current
        if (count == k) {
            result = node;
            return;
        }
        helper(node.right, k);      // Traverse right
    }
}