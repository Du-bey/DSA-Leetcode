class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return f(root) ? null : root;
    }

    public boolean f(TreeNode root){
        if(root == null) return true;
        boolean left = f(root.left);
        boolean right = f(root.right);
        if(left) root.left = null;
        if(right) root.right = null;

        return root.val == 0 && left && right;
    }
}