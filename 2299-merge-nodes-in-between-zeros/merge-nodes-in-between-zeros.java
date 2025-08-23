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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode ret = temp;
        int sum = 0;
        head = head.next;
        while(head != null){
            if(head.val == 0){
                ListNode node = new ListNode(sum);
                sum = 0;
                temp.next = node;
                temp = temp.next;
            }
            else{
                sum += head.val;
            }
            head = head.next;
        }
        return ret.next;
    }
}