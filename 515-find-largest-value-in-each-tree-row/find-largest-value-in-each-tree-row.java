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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode root, int depth, List<Integer> ans){
        if(depth == ans.size()){
            ans.add(root.val);
        }
        else{
            ans.set(depth, Math.max(ans.get(depth), root.val));
        }
        if(root.left != null) dfs(root.left, depth + 1, ans);
        if(root.right != null) dfs(root.right, depth + 1, ans);
    }
}