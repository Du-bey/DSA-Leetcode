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

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode left = head;
        ListNode mid = findmid(head);
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    public ListNode findmid(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode start = new ListNode();
        ListNode ans = start;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                start.next = list1;
                list1 = list1.next;
            }
            else{
                start.next = list2;
                list2 = list2.next;
            }
            start = start.next;
        }
        if(list1 != null){
            start.next = list1;
        }
        if(list2 != null){
            start.next = list2;
        }
        return ans.next;
    }

}