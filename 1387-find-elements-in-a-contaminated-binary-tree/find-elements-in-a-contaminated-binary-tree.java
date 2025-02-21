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
class FindElements {
    HashSet<Integer> h = new HashSet<>();
    public FindElements(TreeNode root) {
        f(root, 0);
    }

    public void f(TreeNode root, int val){
        root.val = val;
        h.add(val);
        if(root.left != null){
            f(root.left, 2* val + 1);
        }
        if(root.right != null){
            f(root.right, 2* val + 2);
        }
    }
    
    public boolean find(int target) {
        return h.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */