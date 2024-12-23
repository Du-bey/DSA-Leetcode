class LRUCache {
    HashMap<Integer, Node> h;
    int cap;
    Node head = new Node(0, 0), tail = new Node(0, 0);

    public LRUCache(int capacity) {
        head.next = tail;
        tail.next = head;
        h = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(h.containsKey(key)){
            Node node = h.get(key);
            int val = node.value;
            deleteLast(node);
            insertFront(key, val);
            return val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(h.containsKey(key)){
            deleteLast(h.get(key));    
        }
        if(h.size() == cap){
            deleteLast(tail.prev);
        }
        insertFront(key, value);
    }

    public void insertFront(int key, int val){
        Node next = head.next;
        Node node = new Node(key, val);
        node.next = next;
        node.prev = head;
        next.prev = node;
        head.next = node;
        h.put(key, node);
    }

    public void deleteLast(Node node){
        h.remove(node.key);
        Node next = node.next;
        Node prev = node.prev;
        
        prev.next = next;
        next.prev = prev;
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int a, int b){
        this.key = a;
        this.value = b;
        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */