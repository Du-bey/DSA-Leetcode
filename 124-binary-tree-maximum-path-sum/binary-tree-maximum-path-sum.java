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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }
    public int find(TreeNode root){
        if(root == null) return 0;
        int lh = find(root.left);
        int rh = find(root.right);
        
        int temp = root.val;
        if(lh < 0) lh = 0;
        if(rh < 0) rh = 0;
        temp += lh +rh;
        max = Math.max(temp, max);
        return root.val + Math.max(lh, rh);
    }
}