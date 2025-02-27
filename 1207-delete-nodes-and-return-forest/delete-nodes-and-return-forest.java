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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> h = new HashSet<>();
        for(int x : to_delete){
            h.add(x);
        }
        if(!h.contains(root.val)) ans.add(root);
        dfs(root, h, ans);
        return ans;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> h, List<TreeNode> ans){
        if(root == null) return root;

        root.left = dfs(root.left, h, ans);
        root.right = dfs(root.right, h, ans);

        if(h.contains(root.val)){
            if(root.left != null){
                ans.add(root.left);
            }
            if(root.right != null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}