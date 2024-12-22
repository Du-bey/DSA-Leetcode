
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.a - b.a);
        int n = lists.length;
        ListNode temp = new ListNode(0);
        ListNode ans = temp;
        for(int i =0;i<n;i++){
            if(lists[i] != null){
                pq.add(new Pair(lists[i].val, lists[i]));
            }
        }
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ListNode node = p.b;
            temp.next = node;
            temp = temp.next;
            node = node.next;
            if(node != null) pq.add(new Pair(node.val, node));
        }
        return ans.next;
    }
}

class Pair{
    int a;
    ListNode b;
    public Pair(int a, ListNode b){
        this.a = a;
        this.b = b;
    }
}