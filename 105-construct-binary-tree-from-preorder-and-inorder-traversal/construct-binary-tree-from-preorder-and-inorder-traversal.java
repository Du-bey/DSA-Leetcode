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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int n = inorder.length;
        for(int i =0;i<n;i++){
            h.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n-1, inorder, 0, n-1, h);
    }

    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> h){
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int inroot = h.get(root.val);
        int numsleft = inroot - is;
        root.left = buildTree(preorder, ps + 1, ps + numsleft, inorder, is, inroot - 1, h);
        root.right = buildTree(preorder, ps + numsleft + 1, pe, inorder, inroot + 1, ie, h);
        return root;
    }
}