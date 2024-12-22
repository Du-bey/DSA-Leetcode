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
        while(l1 != null || l2 != null){
            int tot = c;
            if(l1 != null){
                tot += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                tot += l2.val;
                l2 = l2.next;
            }
            
            c = tot / 10;
            int val = tot % 10;
            
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
        }
        
        if(c == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
        }
        
        return head.next;
    }
}