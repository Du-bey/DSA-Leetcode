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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean odd = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode u = q.poll();
                list.add(u);
                if(u.left != null) q.add(u.left);
                if(u.right != null) q.add(u.right);
            }
            if(odd) reverse(list);
            odd = !odd;
        }
        return root;
    }

    public void reverse(List<TreeNode> list){
        int n = list.size();
        int i = 0;
        int j = n-1;
        while(i <= j){
            int temp = list.get(i).val;
            list.get(i).val = list.get(j).val;
            list.get(j).val = temp;
            
            i++;
            j--;
        }
    }
}