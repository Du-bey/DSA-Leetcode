class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dir = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1, 0}};
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        if (q.isEmpty() || q.size() == n * n) return -1;
        int ans = -1;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            while(size -- > 0){
                Pair p = q.poll();
                int r = p.first;
                int c = p.second;

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >=0 && nc >=0 && nr <n && nc < n && !vis[nr][nc]){
                        q.add(new Pair(nr, nc));
                        vis[nr][nc] = true;
                    }
                }
            }
            
        }
        return ans;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
        
    }
}