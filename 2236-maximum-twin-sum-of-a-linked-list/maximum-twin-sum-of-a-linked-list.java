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
    public int pairSum(ListNode head) {
        int ans = 0;
        ListNode fast = head.next.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = reverseList(slow.next);
        slow = slow.next;
        fast = head;
        while(fast != null && slow != null){
            ans = Math.max(ans, slow.val + fast.val);
            fast = fast.next;
            slow = slow.next;
        }
        return ans;
    }

    public ListNode reverseList(ListNode head) {
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