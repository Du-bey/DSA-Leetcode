class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Triplet> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        int[][] ans = new int[n][m];
        for(int [] r : ans){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 0){
                    ans[i][j] = 0;
                    q.add(new Triplet(0, i, j));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Triplet trip = q.poll();
            int t = trip.a;
            int r = trip.b;
            int c = trip.c;

            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]){
                    q.add(new Triplet(t + 1, nr, nc));
                    ans[nr][nc] = Math.min(ans[nr][nc], t+1);
                    vis[nr][nc] = true;
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