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
    List<Integer> l;
    int n;
    public Solution(ListNode head) {
        l = new ArrayList<>();
        while(head != null){
            l.add(head.val);
            head = head.next;
        }
        n = l.size();
    }
    
    public int getRandom() {
        int x = (int)(Math.random() * n);
        return l.get(x);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */