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
        ListNode temp = head;
        while(temp.next != null){
            ListNode temp1 = temp;
            ListNode temp2 = temp.next;
            ListNode temp3 = new ListNode(gcd(temp1.val, temp2.val));
            temp.next = temp3;
            temp3.next = temp2;
            temp = temp.next.next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
        
    }
}