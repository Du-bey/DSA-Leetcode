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
    public ListNode doubleIt(ListNode head) {
        int lc = f(head);
        if(lc > 0){
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public int f(ListNode head){
        if(head == null) return 0;
        int car = f(head.next);
        int val = (head.val * 2) + car;
        head.val = val % 10;
        return val / 10;
    }
}