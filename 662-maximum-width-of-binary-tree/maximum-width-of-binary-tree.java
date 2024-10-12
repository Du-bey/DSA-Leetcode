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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            for(int i =0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int num = p.num;
                int ind = num - min;
                ind *= 2;
                if(node.left != null) q.add(new Pair(node.left, ind + 1));
                if(node.right != null) q.add(new Pair(node.right, ind + 2));
                ans = Math.max(ans, num - min + 1);
            }
        }
        return ans;
    }
}

class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}