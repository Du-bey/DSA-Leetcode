class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Trip> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Trip(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            Trip p = q.poll();
            int r = p.r;
            int c = p.c;
            int t = p.t;
            ans = Math.max(ans, t);
            for(int i =0;i<4;i++){
                int nr = r + delr[i];
                int nc = c + delc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    vis[nr][nc] = true;
                    q.add(new Trip(nr, nc, t+1));
                    grid[nr][nc] = 2;
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}

class Trip{
    int r;
    int c;
    int t;
    public Trip(int r, int c, int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }
}