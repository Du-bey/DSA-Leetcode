class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        f(root);
        return ans;
    }

    public int f(TreeNode root){
        if(root == null) return 0;

        int left = f(root.left);
        int right = f(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}