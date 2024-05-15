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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if( root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int flag = 0;
        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int l = q.size();
            for(int i =0;i<l;i++){
                TreeNode node = q.peek();
                subList.add(node.val);
                q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(flag == 0){
                ans.add(subList);
            }
            else{
                Collections.reverse(subList);
                ans.add(subList);
            }
            flag = 1 - flag;
        }
        return ans;
    }
}