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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode temp = dum;
        for(int i = 0;i<left-1;i++){
            temp = temp.next;
        }


        ListNode prev = null;
        ListNode temp1 = temp.next;
        ListNode last = temp1;
        int r = right - left + 1;
        int cnt = 0;
        while(temp1 != null && cnt < r){
            ListNode next = temp1.next;
            temp1.next = prev;
            prev = temp1;
            temp1 = next;
            cnt++;
        }
        if(last != null) last.next = temp1;
        temp.next = prev;
        return dum.next;
    }
}