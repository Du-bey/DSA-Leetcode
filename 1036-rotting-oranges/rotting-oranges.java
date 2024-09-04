class Solution {
    public int orangesRotting(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        int ans = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.t;
            if(vis[r][c]) continue;
            vis[r][c] = true;
            ans = Math.max(ans, t);
            for(int i=0;i<4;i++){
                int nr = r + delr[i];
                int nc = c + delc[i];
                if(nr>=0 && nc >=0 && nr < n && nc < m && board[nr][nc] == 1){
                    q.add(new Pair(nr, nc, t+1));
                    board[nr][nc] = 2;
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}


class Pair{
    int r;
    int c;
    int t;
    public Pair(int r, int c, int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }   
}