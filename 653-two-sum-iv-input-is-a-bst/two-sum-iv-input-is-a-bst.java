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
    
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        inorder(root, a);
        int n = a.size();
        int l = 0;
        int r = n-1;
        while(l < r){
            int lv = a.get(l);
            int rv = a.get(r);
            int sum = lv + rv;
            if(sum == k){
                return true;
            }
            else if(sum < k){
                l++;
            }
            else{
                r--;
            }
        }
        return false;
    }

    public void inorder(TreeNode root, ArrayList<Integer> a) {
        if(root == null) return;
        inorder(root.left, a);
        a.add(root.val);
        inorder(root.right, a);
    }
}