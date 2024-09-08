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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        ListNode[] ans = new ListNode[k];
        if(head == null || k == 0){
            return ans;
        }
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        int a = n / k;
        int b = n % k;
        ListNode node = head;
        ListNode prev = null;
        
        for(int i =0;i < k;i++){
            if(node == null) break;
            ans[i] = node;
            
            for(int j =0;j<a;j++){
                prev = node;
                node = node.next;
            }
            if(b > 0) {
                prev = node;
                node = node.next;
                b--;
            }
            prev.next = null;
        }
        return ans;
    }
}