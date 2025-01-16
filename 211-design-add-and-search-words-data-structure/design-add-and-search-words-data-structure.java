class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            int val = c - 'a';
            if(node.links[val] == null){
                node.links[val] = new Node();
            }
            node = node.links[val];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        return searchUtils(root, word);
    }

    public boolean searchUtils(Node root, String word){
        Node node = root;
        int n = word.length();
        for(int j =0;j<n;j++){
            char c = word.charAt(j);
            if(c != '.'){
                int val = c - 'a';
                if(node.links[val] == null){
                    return false;
                }
                node = node.links[val];
            }
            else{
                for(int i =0;i<26;i++){
                    if(node.links[i] != null){
                        if(searchUtils(node.links[i], word.substring(j + 1))){
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return node != null && node.flag;
    }
}

class Node{
    Node[] links = new Node[26];
    boolean flag = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */