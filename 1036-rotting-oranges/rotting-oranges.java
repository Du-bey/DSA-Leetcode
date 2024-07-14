class Solution {
    public int orangesRotting(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            int r = p.r;
            int c = p.c;
            int t = p.t;
            ans = Math.max(ans, t);
            for(int i =0;i<4;i++){
                int newr = r + delr[i];
                int newc = c + delc[i];
                if(newr >=0 && newc >=0 && newr < n && newc < m && !vis[newr][newc] && board[newr][newc] == 1){
                    vis[newr][newc] = true;
                    q.add(new Pair(newr, newc, t +1));  
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && board[i][j] == 1){
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