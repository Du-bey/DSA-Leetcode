class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        Node root = new Node();
        for(String word : words) {
            Node node = root;
            for(char c : word.toCharArray()){
                int val = c - 'a';
                if(node.links[val] == null){
                    node.links[val] = new Node();
                }
                node = node.links[val];
                node.cnt++;
            }
        }
        Node node = root;
        int m = pref.length();
        for(int i =0;i<m; i++){
            char c = pref.charAt(i);
            int val = c - 'a';
            if(node.links[val] == null){
                if(i != m - 1) count = 0;
                break;
            }
            node = node.links[val];
            count = node.cnt;
        }
        return count;
    }
}

class Node{
    Node[] links = new Node[26];
    int cnt = 0;
}