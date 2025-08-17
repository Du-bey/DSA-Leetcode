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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        HashSet<Integer> h = new HashSet<>();
        for(int x : nums) h.add(x);

        ListNode prev = temp;
        while(head != null){
            if(h.contains(head.val)){
                prev.next = head.next;
            }
            else{
                prev = prev.next;
            }
            head = head.next;
        }
        return temp.next;
    }
}