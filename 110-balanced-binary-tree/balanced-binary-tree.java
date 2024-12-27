
class Solution {
    public boolean isBalanced(TreeNode root) {
        return diff(root) != -1;
    }

    public int diff(TreeNode root) {
        if(root == null) return 0;
        int left = diff(root.left);
        int right = diff(root.right);
        if(left == -1 || right == -1) return -1;
        int diff = Math.abs(left - right);
        if(diff > 1) return -1;
        return 1 + Math.max(left, right);
    }
}