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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int n =1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        if(k % n == 0) return head;
        k = k % n;
        k = n - k;
        ListNode temp2 = head;
        for(int i =0;i<k-1;i++){
            temp2 = temp2.next;
        }
        ListNode ans = temp2.next;
        temp2.next = null;
        temp.next = head;
        return ans;
    }
}