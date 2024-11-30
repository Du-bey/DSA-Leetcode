class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Triplet> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Triplet(0, i, j));
                }
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            Triplet trip = q.poll();
            int t = trip.a;
            int r = trip.b;
            int c = trip.c;

            ans = Math.max(ans, t);

            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                    q.add(new Triplet(t + 1, nr, nc));
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