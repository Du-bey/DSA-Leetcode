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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = new int[1];
        i[0] = 0;
        return bst(preorder, i, Integer.MAX_VALUE);
    }

    public TreeNode bst(int[] preorder, int[] i, int bound){
        if(i[0] >= preorder.length || preorder[i[0]] > bound) return null;
        TreeNode node = new TreeNode(preorder[i[0]++]);
        node.left = bst(preorder, i, node.val);
        node.right = bst(preorder, i, bound);
        return node;
    }
}