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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean first = true;
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                if(first){
                    first = false;
                    ans.add(node.val);
                }
                if(node.right != null) q.add(node.right);
                if(node.left != null) q.add(node.left);
            }
            
        }
        return ans;
    }
}