class Solution {
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    vis[i][j] = true;
                    bfs(i, j, vis, grid, n, m);
                }
            }
        }
        return ans;
    }

    public void bfs(int i, int j, boolean [][] vis, int[][] grid, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        int cnt = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            cnt++;
            for(int ind= 0;ind<4;ind++){
                int nr = r + delr[ind];
                int nc = c + delc[ind];
                if(nr >=0 && nc >=0 && nr <n && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        ans = Math.max(ans, cnt);
        
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