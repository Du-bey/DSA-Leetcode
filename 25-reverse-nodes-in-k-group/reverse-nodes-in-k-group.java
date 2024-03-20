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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kNode = findKthNode(temp, k);
            if(kNode == null) {
                prevNode.next = temp;
                break;
            }
            ListNode nextNode = kNode.next;
            kNode.next = null;
            ListNode newHead = reverseList(temp);
        
            if(temp == head) head = newHead;
            else prevNode.next = kNode;
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        while(k > 1){
            if(temp.next == null) return null;
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}