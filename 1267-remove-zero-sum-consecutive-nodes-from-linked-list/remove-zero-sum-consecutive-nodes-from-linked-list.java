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
        ListNode prev = new ListNode(-1);
        prev.next = head;
        int sum = 0;
        HashMap<Integer, ListNode> h = new HashMap<>();
        h.put(0, prev);

        while(head != null){
            sum += head.val;
            if(h.containsKey(sum)){
                ListNode last = h.get(sum);
                ListNode temp = last;
                int psum = sum;
                while(temp.next != head){
                    temp = temp.next;
                    psum += temp.val;
                    h.remove(psum);   
                }
                last.next = head.next;
            }
            else{
                h.put(sum, head);
            }
            head = head.next;
        }
        return prev.next;
    }
}