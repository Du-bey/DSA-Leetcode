class Solution {
    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for(String s : words){
            Node node = root;
            for(char c: s.toCharArray()){
                if(node.links[c - 'a'] == null){
                    node.links[c - 'a'] = new Node();
                }
                node = node.links[c - 'a'];
                node.cnt++;
            }
        }
        int[] ans = new int[words.length];
        int ind =0;
        for(String s : words){
            int cnt = 0;
            Node node = root;
            for(char c: s.toCharArray()){
                node = node.links[c - 'a'];
                cnt += node.cnt;
            }
            ans[ind++] = cnt;
        }
        return ans;
    }
}
class Node{
    Node[] links = new Node[26];
    int cnt = 0;
}