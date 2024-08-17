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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;
        if(head == null || head.next == null) return null;
        while(temp !=null){
            temp = temp.next;
            cnt++;
        }
        int k = cnt - n;
        if(k == 0) return head.next;
        temp = head;
        for(int i =0;i<k-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}