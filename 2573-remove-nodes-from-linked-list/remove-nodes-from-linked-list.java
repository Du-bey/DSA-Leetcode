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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int max = head.val;
        ListNode temp = head.next;
        ListNode prev = head;
        while(temp != null){
            if(temp.val < max){
                prev.next = temp.next;
            }
            else{
                max = temp.val;
                prev = temp;
            }
            temp = temp.next;
        }
        return reverse(head);
    }

    public ListNode reverse(ListNode head){
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