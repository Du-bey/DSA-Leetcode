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
        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode b = reverse(slow.next);
        slow.next = null;
        ListNode ans = head;
        ListNode a = head;
        while(b != null){
            ListNode t1 = a.next;
            ListNode t2 = b.next;
            a.next = b;
            b.next = t1;
            a = t1;
            b = t2;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}