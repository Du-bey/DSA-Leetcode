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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = reverse(slow.next);
        while(head != null && revHead != null){
            ListNode next = head.next;
            ListNode rnext = revHead.next;
            head.next = revHead;
            revHead.next = next;
            head = next;
            revHead = rnext;
        }
        head.next = null;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
