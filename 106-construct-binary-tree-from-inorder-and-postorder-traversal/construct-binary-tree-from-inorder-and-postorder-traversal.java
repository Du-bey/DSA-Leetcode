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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int n = inorder.length;
        for(int i =0;i<n;i++){
            h.put(inorder[i], i);
        }
        return buildTree(postorder, 0, n-1, inorder, 0, n-1, h);
    }

    public TreeNode buildTree(int[] postorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> h){
        if(ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int inroot = h.get(postorder[pe]);
        int numsleft = inroot - is;

        root.left = buildTree(postorder, ps , ps + numsleft - 1, inorder, is, inroot - 1, h);
        root.right = buildTree(postorder, ps + numsleft , pe - 1, inorder, inroot + 1, ie, h);
        return root;
    }
}