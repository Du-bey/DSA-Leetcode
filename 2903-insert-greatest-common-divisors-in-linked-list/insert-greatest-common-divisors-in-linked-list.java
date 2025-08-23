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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        while(head.next != null){
            ListNode next = head.next;
            int a = head.val;
            int b = next.val;
            int gcd = gcd(a, b);
            ListNode g = new ListNode(gcd, next);
            head.next = g;
            head = next;
        }
        return temp;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
        
    }
}