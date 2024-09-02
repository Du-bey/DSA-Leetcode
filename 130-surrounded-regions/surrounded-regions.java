class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(board[i][j] == 'O'){
                        q.add(new Pair(i, j));
                        vis[i][j] = true;
                    }
                }
            }
        }
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int i=0;i<4;i++){
                int nr = r + delr[i];
                int nc = c + delc[i];
                if(nr>=0 && nc >=0 && nr < n && nc < m && board[nr][nc] == 'O' && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
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


class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }   
}