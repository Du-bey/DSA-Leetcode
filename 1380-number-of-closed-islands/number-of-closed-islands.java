class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 0){
                        bfs(i, j, grid, n, m);
                        grid[i][j] = 1;
                    }
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 0){
                    bfs(i, j, grid, n, m);
                    cnt++;
                    grid[i][j] = 1;
                }
            }
        }
        return cnt;
    }

    public void bfs(int i1, int j1, int[][] grid, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i1, j1));
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            int r = p.r;
            int c = p.c;
            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >=0 && nc < m && grid[nr][nc] == 0){
                    q.add(new Pair(nr, nc));
                    grid[nr][nc] = 1;
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