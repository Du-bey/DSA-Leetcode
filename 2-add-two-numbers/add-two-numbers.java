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
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1 !=null && l2 != null){
            int val = l1.val + l2.val;
            System.out.println(l1.val + " " + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            if(carry == 1) val++;
            carry = val/10;
            val = val % 10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = node;
        }
        while(l1 !=null){
            int val = l1.val ;
            if(carry == 1) val++;
            carry = val/10;
            val = val % 10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = node;
            l1 = l1.next;
        }

        while(l2 !=null){
            int val = l2.val;
            if(carry == 1) val++;
            carry = val/10;
            val = val % 10;
            ListNode node = new ListNode(val);
            head.next = node;
            head = node;
            l2 = l2.next;
        }
        if(carry == 1){
            ListNode node = new ListNode(carry);
            head.next = node;
        }
        return temp.next;
    }
}