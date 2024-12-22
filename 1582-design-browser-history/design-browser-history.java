class BrowserHistory {

    public class Node{
        String url;
        Node next, prev;
        public Node(String url){
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }
    Node node;
    public BrowserHistory(String homepage) {
        node = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        node.next = newNode;
        newNode.prev = node;
        node = node.next;
    }
    
    public String back(int steps) {
        while(node.prev != null && steps > 0){
            steps--;
            node = node.prev;
        }
        return node.url;
    }
    
    public String forward(int steps) {
        while(node.next != null && steps > 0){
            steps--;
            node = node.next;
        }
        return node.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */