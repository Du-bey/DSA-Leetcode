class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        int val = dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);

        int leftPath = 0, rightPath = 0;

        if(root.left != null && root.left.val == root.val) {
            leftPath = leftLen + 1;
        }

        if(root.right != null && root.right.val == root.val) {
            rightPath = rightLen + 1;
        }

        max = Math.max(leftPath + rightPath, max);

        return Math.max(leftPath, rightPath);
    }
}