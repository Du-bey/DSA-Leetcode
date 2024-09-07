/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode t, TreeNode s) {
        if(t == null) return true;
        if (s == null) return false;

        return isSame(s, t) || isSubPath(t, s.left) || isSubPath(t, s.right);
    }
    
    private boolean isSame(TreeNode s, ListNode t) {
        if(t == null) return true;
        if (s == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.next) || isSame(s.right, t.next);
    }
}