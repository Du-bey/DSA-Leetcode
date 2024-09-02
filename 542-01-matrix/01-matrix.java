class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ;i<n;i++){
            for(int j =0;j<m;j++){
                ans[i][j] = Integer.MAX_VALUE;
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while(!q.isEmpty()){
            Pair p = q.peek();
            q.remove();
            int r = p.r;
            int c = p.c;
            int l = p.l;
            for(int i =0;i<4;i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr >= 0 && nr < n && nc >=0 && nc < m && !vis[nr][nc] && mat[nr][nc] == 1){
                        ans[nr][nc] = l+1;
                        q.add(new Pair(nr, nc, l+1));
                        vis[nr][nc] = true;
                    }
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