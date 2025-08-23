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
            Node copy = new Node(temp.val);
            h.put(temp, copy);
            temp = temp.next;
        }

        Node copyHead = h.get(head);
        Node temp2 = copyHead;
        while(head != null){
            temp2.next = h.get(head.next);
            temp2.random = h.get(head.random);
            temp2 = temp2.next;
            head = head.next;
        }
        return copyHead;
    }
}