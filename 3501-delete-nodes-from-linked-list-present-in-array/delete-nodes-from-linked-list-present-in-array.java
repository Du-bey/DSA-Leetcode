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
        HashSet<Integer> h = new HashSet<>();
        for(int x : nums){
            h.add(x);
        }
        ListNode temp = new ListNode(-1);
        ListNode cur = head;
        ListNode prev = temp;
        
        temp.next = head;
        while(cur != null){
            int val = cur.val;
            if(h.contains(val)){
                prev.next = cur.next;
            }
            else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return temp.next;
    }
}