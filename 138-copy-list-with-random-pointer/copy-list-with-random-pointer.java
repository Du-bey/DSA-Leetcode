/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> h = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node dummyHead = new Node(temp.val);
            h.put(temp, dummyHead);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node dt = h.get(temp);
            Node n = temp.next;
            Node r = temp.random;
            Node dn = h.get(n);
            Node dr = h.get(r);
            dt.next = dn;
            dt.random = dr;
            h.put(temp, dt);
            temp = temp.next;
        }
        return h.get(head);
    }
}


