class Trie {
    private static Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.links[ch - 'a'] == null){
                node.links[ch-'a'] = new Node();
            }
            node = node.links[ch-'a'];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.links[ch - 'a'] == null){
                return false;
            }
            node = node.links[ch-'a'];
        }
        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i =0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(node.links[ch - 'a'] == null){
                return false;
            }
            node = node.links[ch-'a'];
        }
        return true;
    }

    class Node{
        Node[] links = new Node[26];
        boolean flag = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */