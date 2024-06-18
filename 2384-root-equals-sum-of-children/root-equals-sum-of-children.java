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
    public boolean checkTree(TreeNode root) {
        if (root == null) return true;
        int val = Integer.MIN_VALUE;
        if(root.left != null){
            val = 0;
            TreeNode left = root.left;
            val += left.val;
            if(checkTree(root.left) == false) {
                return false;
            }
        }
        
        if(root.right != null){
            TreeNode right = root.right;
            val += right.val;
            checkTree(root.right);
            if(checkTree(root.left) == false) {
                return false;
            }
        }
        if(val != Integer.MIN_VALUE && val != root.val) {
            return false;
        }
        return true;
    }
}