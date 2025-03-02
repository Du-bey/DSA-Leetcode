class LFUCache {
    HashMap<Integer, Node> cache;
    HashMap<Integer, DLL> freqMap;
    final int cap;
    int cursize;
    int minFreq;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        this.cap = capacity;
        cursize = 0;
        minFreq = 0;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        updateNode(node);
        return node.val;
    }

    public void updateNode(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);
        
        if(minFreq == node.freq && list.size == 0){
            minFreq++;
        }
        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            updateNode(node);
        }
        else{
            cursize++;
            if (cursize > cap) {
                DLL minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                cursize--;
            }
            
            minFreq = 1;
            Node newNode = new Node(key, value);

            DLL curList = freqMap.getOrDefault(1, new DLL());
            curList.add(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }
}

class Node{
    int key;
    int val;
    int freq;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLL{
    int size;
    Node head;
    Node tail;
    public DLL(){
        this.size = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    public void add(Node node){
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
        size++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */