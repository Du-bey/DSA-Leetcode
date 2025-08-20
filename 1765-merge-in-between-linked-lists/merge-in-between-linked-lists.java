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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        ListNode bn = temp;
        ListNode apn = temp;
        int cnt = 0;
        while(temp != null){
            if(a - 1 == cnt) apn = temp;
            if(b + 1 == cnt){
                bn = temp;
                break;
            }
            cnt++;
            temp = temp.next;
        }
        apn.next = list2;
        while(list2.next != null) list2 = list2.next;
        list2.next = bn;
        return list1;
    }
}