class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        boolean[][] vis = new boolean[n][m];
        pq.add(new Tuple(grid[0][0],0,0));
    
        int ans = 0;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int d = t.d;
            int r = t.x;
            int c = t.y;
            if(vis[r][c]) continue;
            vis[r][c] = true;
            ans = Math.max(ans, d);
            if(r == n-1 && c == m-1) return ans;
            for(int i =0;i<4;i++){
                int nr = r + delr[i];
                int nc = c + delc[i];
                if(nr >=0 && nc >= 0 && nr <n && nc < m){
                    pq.add(new Tuple(grid[nr][nc], nr, nc));
                }
            }
        }
        return 0;
    }
}


class Tuple {
    int d, x, y;
    public Tuple(int d, int x, int y) {
        this.d = d;
        this.x = x;
        this.y = y;
    }
}