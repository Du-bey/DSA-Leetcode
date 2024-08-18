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
        ListNode node = new ListNode(-1);
        ListNode ans = node;
        int n = lists.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i =0;i<n;i++){
            ListNode temp =lists[i];
            while(temp != null){
                int data = temp.val;
                Pair p = new Pair(data, temp);
                pq.add(p);
                temp = temp.next;
            }
        }
        while(!pq.isEmpty()){
            node.next = pq.poll().node;
            node = node.next;
        }
        node.next = null;
        return ans.next;
    }

}

class Pair{
    int val;
    ListNode node;

    public Pair(int val, ListNode node){
        this.val = val;
        this.node = node;
    }
}