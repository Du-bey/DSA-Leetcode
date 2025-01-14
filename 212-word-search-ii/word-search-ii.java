class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);
        List<String> ans = new ArrayList<>();
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int i, int j, Node p, List<String> ans) {
        char c = board[i][j];
        if(c == '#' || p.links[c - 'a'] == null) return;
        p = p.links[c - 'a'];

        if(p.word != null){
            ans.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';

        if(i > 0) dfs(board, i-1, j, p, ans);
        if(j > 0) dfs(board, i, j-1, p, ans);
        if(i < board.length - 1) dfs(board, i+1, j, p, ans);
        if(j < board[0].length - 1) dfs(board, i, j+1, p, ans);

        board[i][j] = c;
    }

    public Node buildTrie(String[] words){
        Node root = new Node();
        for(String w : words){
            Node p = root;
            for(char c : w.toCharArray()){
                int i = c - 'a';
                if(p.links[i] == null) p.links[i] = new Node();
                p = p.links[i];
            }
            p.word = w;
        }
        return root;
    }
}

class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    String word;
}