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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        ListNode a = lists[0];
        if(n == 1) return a;
        for(int i = 1;i<n;i++){
            ListNode b = lists[i];
            a = merge(a, b);
        }
        return a;
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