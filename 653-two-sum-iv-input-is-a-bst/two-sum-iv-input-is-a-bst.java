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





class BSTIterator{
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode node, boolean rev){
        reverse = rev;
        pushAll(node);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public int next(){
        TreeNode temp = st.pop();
        if(reverse) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }

    private void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            if(reverse) node = node.right;
            else node = node.left;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while(i < j){
            int sum = i + j;
            if(sum == k) return true;
            if(sum > k) j = r.next();
            else i = l.next();
        }
        return false;
    }
}