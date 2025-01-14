class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();

        for(int i =0 ;i < wordsContainer.length;i++){
            String s = wordsContainer[i];
            if (wordsContainer[root.ind].length() > wordsContainer[i].length()) {
                root.ind = i;
            }
            Node node = root;
            for(int j = s.length() - 1; j >=0; j--){
                char c = s.charAt(j);
                int val = c - 'a';
                if(node.links[val] == null){
                    node.links[val] = new Node();
                    node.links[val].ind = i;
                }
                node = node.links[val];
                if(wordsContainer[node.ind].length() > s.length()){
                    node.ind = i;
                }
            }
        }

        int n = wordsQuery.length;
        int[] ans = new int[n];

        for(int j=0;j<n;j++){
            String s = wordsQuery[j];
            char[] c = s.toCharArray();
            Node node = root;
            int res = -1;
            for(int i = c.length - 1; i>=0; i--){
                int val = c[i] - 'a';
                if(node.links[val] == null){
                    res = node.ind;
                    break;
                }
                node = node.links[val];
            }
            if(res == -1) res = node.ind;
            ans[j] = res;
        }
        return ans;
    }
}

class Node{
    Node[] links = new Node[26];
    int ind = 0;
}