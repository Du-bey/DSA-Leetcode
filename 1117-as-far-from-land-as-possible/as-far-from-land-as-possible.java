class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dir = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1, 0}};
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int ans = -1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            int t = p.t;

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >=0 && nc >=0 && nr <n && nc < n && !vis[nr][nc]){
                    q.add(new Pair(nr, nc, t+1));
                    vis[nr][nc] = true;
                    ans = Math.max(ans, t+1);
                }
            }
        }
        return ans;
    }
}

class Pair{
    int first;
    int second;
    int t;

    public Pair(int first, int second, int t){
        this.first = first;
        this.second = second;
        this.t = t;
        
    }
}