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
        boolean found = false;
        int sum = 0;
        while(head != null){
            if(head.val == 0){
                if(found){
                    ListNode node = new ListNode(sum);
                    sum = 0;
                    temp.next = node;
                    temp = temp.next;
                }
                else found = true;
            }   
            else{
                sum += head.val;
            }
            head = head.next;
        }
        return ret.next;
    }
}