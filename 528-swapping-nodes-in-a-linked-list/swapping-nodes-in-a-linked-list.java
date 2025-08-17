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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0;i<k-1;i++){
            fast = fast.next;
        }
        ListNode temp = fast;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        int d = temp.val;
        temp.val = slow.val;
        slow.val = d;
        return head;
    }
}