class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i ==0 || j ==0 || i == n-1 || j == m-1){
                    if(board[i][j] == 'O'){
                        q.add(new Pair(i, j));
                        vis[i][j] =true;
                    }
                }
            }
        }
        int[] delr = {0,-1,0,1};
        int[] delc = {-1,0,1, 0};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int i =0;i<4;i++){
                int newr = r+delr[i];
                int newc = c+delc[i];
                if(newr >=0 && newc >=0 && newr<n && newc <m && !vis[newr][newc] && board[newr][newc] == 'O'){
                    vis[newr][newc] = true;
                    q.add(new Pair(newr, newc));
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}