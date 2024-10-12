/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        int pval = p.val;
        int qval = q.val;
        if(val < pval && val < qval) return lowestCommonAncestor(root.right, p, q);
        if(val > pval && val > qval) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}