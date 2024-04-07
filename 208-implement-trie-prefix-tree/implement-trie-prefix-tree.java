class Trie {
    private static Node root; 

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(word.charAt(i), new Node()); 
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i =0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {}

    boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    Node get(char ch) {
        return links[ch-'a']; 
    }
    void put(char ch, Node node) {
        links[ch-'a'] = node; 
    }

    void setEnd() {
        flag = true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */