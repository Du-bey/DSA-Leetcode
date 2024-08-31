class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        
        int ans = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    ans++;
                    vis[i][j] = true;
                    bfs(vis, i, j, grid, n, m);
                }
            }
        }
        return ans;
    }
    
    public void bfs(boolean[][] vis, int i, int j, char[][] grid, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
    
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int ind =0;ind<4;ind++){
                int nr = r + delr[ind];
                int nc = c + delc[ind];
                if(nr < n && nc < m && nr >=0 && nc >=0 && grid[nr][nc] == '1' && !vis[nr][nc]){
                    
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
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