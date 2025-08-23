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
        ListNode nhead = reverse(head);
        int car = 0;
        ListNode temp = nhead;
        while(nhead != null){
            int val = nhead.val * 2 + car;
            car = val / 10;
            nhead.val = val % 10;
            
            if(nhead.next == null && car > 0){
                ListNode newNode = new ListNode(1);
                nhead.next = newNode;
                break;
            }
            nhead = nhead.next;
        }
        
        return reverse(temp);
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