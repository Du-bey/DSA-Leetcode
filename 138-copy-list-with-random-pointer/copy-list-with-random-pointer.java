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
        Node temp = head;
        while(temp != null){
            Node cNode = new Node(temp.val);
            cNode.next = temp.next;
            temp.next = cNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null){
            Node cNode = temp.next;
            Node r = temp.random;
            if(r != null){
                cNode.random = r.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node d = new Node(-1);
        Node res = d;
        while(temp != null){
            Node cNode = temp.next;
            res.next = cNode;
            temp.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }
        return d.next;
    }
}