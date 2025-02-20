class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ;i<n;i++){
            for(int j =0;j<m;j++){
                if((i == 0 || j == 0 || i == n-1 || j== m-1) && grid[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            int r = p.r;
            int c = p.c;
            for(int i =0;i<4;i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr >= 0 && nr < n && nc >=0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                        q.add(new Pair(nr, nc));
                        vis[nr][nc] = true;
                    }
            }
        }

        int cnt = 0;
        for(int i = 0 ;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
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