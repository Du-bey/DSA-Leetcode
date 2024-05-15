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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return diff(root) != -1;
        
    }
    public int diff(TreeNode root){
        if(root == null) return 0;
        int lh = diff(root.left);
        int rh = diff(root.right);
        if(lh == -1 || rh == -1) return -1;
        int dif = Math.abs(lh-rh);
        if(dif > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
}