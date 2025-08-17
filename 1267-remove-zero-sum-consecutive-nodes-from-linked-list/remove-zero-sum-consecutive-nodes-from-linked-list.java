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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        int sum = 0;
        HashMap<Integer, ListNode> h = new HashMap<>();
        h.put(0, prev);

        ListNode temp = head;

        while(temp != null){
            sum += temp.val;
            h.put(sum, temp);
            temp = temp.next;
        }

        sum = 0;
        temp = prev;
        while(temp != null){
            sum += temp.val;
            temp.next = h.get(sum).next;
            temp = temp.next;
        }
        return prev.next;
    }
}