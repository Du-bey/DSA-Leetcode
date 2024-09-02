class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n == 1 && m == 1) return grid[0][0];
        boolean [][] vis = new boolean[n][m];
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int size = bfs(i, j, vis, grid, n, m);
                    vis[i][j] = true;
                    cnt = Math.max(cnt, size);
                }
            }
        }
        return cnt;
    }

    public int bfs(int i, int j, boolean [][] vis, int[][] grid, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int cnt = 0;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            if(vis[r][c]) continue;
            vis[r][c] = true;
            cnt++;
            
            for(int ind= 0;ind<4;ind++){
                int nr = r + delr[ind];
                int nc = c + delc[ind];
                if(nr >=0 && nc >=0 && nr <n && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    
                    q.add(new Pair(nr, nc));
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