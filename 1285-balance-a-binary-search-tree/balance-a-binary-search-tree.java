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
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorder(l, root);
        return f(0, l.size() - 1, l);    
    }

    public TreeNode f(int l, int h, List<Integer> list){
        if(l > h) return null;

        int mid = (l+h)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = f(l, mid - 1, list);
        node.right = f(mid + 1, h, list);
        return node;
    }

    public void inorder(List<Integer> l, TreeNode root){
        if(root == null) return;
        inorder(l, root.left);
        l.add(root.val);
        inorder(l, root.right);
    }
}