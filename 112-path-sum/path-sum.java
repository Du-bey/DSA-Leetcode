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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return f(root, 0, targetSum);
    }

    public boolean f(TreeNode root, int sum, int t){
        if(root == null) return false;

        sum += root.val;
        if(root.left == null && root.right == null && sum == t){
            return true;
        }

        return f(root.left, sum, t) || f(root.right, sum, t);
    }
}