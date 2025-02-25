class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int l = p.l;
            ans = Math.max(ans, l);

            for(int ind= 0;ind<4;ind++){
                int nr = r + delr[ind];
                int nc = c + delc[ind];
                if(nr >=0 && nc >=0 && nr <n && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr, nc, l+1));
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return ans;
    }
}


class Pair{
    int r;
    int c;
    int l;
    public Pair(int r, int c, int l){
        this.r = r;
        this.c = c;
        this.l = l;
    }
}