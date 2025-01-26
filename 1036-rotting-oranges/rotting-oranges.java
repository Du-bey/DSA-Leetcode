class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        boolean[][] vis = new boolean[n][m];
        Queue<Triplet> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new Triplet(0, i, j));
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int dis = t.a;
            int r = t.b;
            int c = t.c;
            ans = Math.max(ans, dis);
            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    q.add(new Triplet(dis + 1, nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;
    }
}

public class Triplet {
    int a;
    int b;
    int c;

    public Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}