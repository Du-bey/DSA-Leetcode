class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
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
        int cnt = 1;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        vis[i][j] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            
            for(int ind= 0;ind<4;ind++){
                int nr = r + delr[ind];
                int nc = c + delc[ind];
                if(nr >=0 && nc >=0 && nr <n && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    cnt++;
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
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