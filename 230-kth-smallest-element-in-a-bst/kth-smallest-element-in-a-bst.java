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
    public int kthSmallest(TreeNode root, int k) {
         int[] ans = new int[2];
         ans[0] = k-1;
         ans[1] = -1;
         int[] cnt = new int[1];
         cnt[0] = 0;
         inOrder(root, ans, cnt);
         return ans[1];
    }

    public void inOrder(TreeNode root, int[] ans, int[] cnt) {
        if(root == null){
            return;
        }
        inOrder(root.left, ans, cnt);
        if(ans[0] == cnt[0]){
            if(ans[1] == -1) ans[1] = root.val;
            return;
        }
        cnt[0]++;
        inOrder(root.right, ans, cnt);
    }
}