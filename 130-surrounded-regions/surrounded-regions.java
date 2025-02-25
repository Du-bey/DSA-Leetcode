class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 'O'){
                        q.add(new Pair(i, j));
                        vis[i][j] = true;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;

            for(int ind= 0;ind<4;ind++){
                int nr = r + delr[ind];
                int nc = c + delc[ind];
                if(nr >=0 && nc >=0 && nr <n && nc < m && !vis[nr][nc] && grid[nr][nc] == 'O'){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'O' && !vis[i][j]) grid[i][j] = 'X';
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