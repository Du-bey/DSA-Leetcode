class Solution {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        f(root, Integer.MAX_VALUE);
        return ans;
    }

    public int f(TreeNode root, int val){
        if(root == null) return 0;
        int left = f(root.left, root.val);
        int right = f(root.right, root.val);
        ans = Math.max(ans, left + right);
        if(root.val != val) return 0;
        return 1 + Math.max(left, right);
    }
}