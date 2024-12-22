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
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        int c = 0;
        while(l1 != null && l2 != null){
            int a = l1.val;
            int b = l2.val;
            int tot = a + b + c;
            c = tot / 10;
            int val = tot % 10;
            
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int a = l1.val + c;
            c = a / 10;
            int val = a % 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int a = l2.val;
            a += c;
            c = a / 10;
            int val = a % 10;
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
            l2 = l2.next;
        }
        if(c == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        
        return head.next;
    }
}