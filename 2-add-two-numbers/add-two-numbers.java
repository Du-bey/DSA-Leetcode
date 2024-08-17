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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        int val = 0;
        while(l1 != null && l2 != null){
            val = l1.val + l2.val +c;
            c = val/10;
            val = val % 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            val = l1.val + c;
            c = val/10;
            val = val % 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
            l1 = l1.next;
        }

        while(l2 != null){
            val = l2.val + c;
            c = val/10;
            val = val % 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = node;
            l2 = l2.next;
        }
        if(c == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        return head.next;
    }
}