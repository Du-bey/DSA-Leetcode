class Solution {
    int[][] dir = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dis = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                Pair p = q.poll();
                int r = p.first;
                int c = p.second;
                dis[r][c] = level;
                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >=0 && nc >=0 && nr <n && nc < n && !vis[nr][nc]){
                        q.add(new Pair(nr, nc));
                        vis[nr][nc] = true;
                    }
                }
            }
            level++;
        }

        int l = 0;
        int h = 400;
        int ans = 0;
        while(l <= h){
            int m = (l+h)/2;
            if(possible(dis, m)){
                l = m + 1;
                ans = m;
            }
            else{
                h = m - 1;
            }
        }
        return ans;
    }

    public boolean possible(int[][] dis, int m){
        int n = dis.length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.add(new Pair(0, 0));
        vis[0][0] = true;

        if(dis[0][0] < m) return false;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;

            if(r == n-1 && c == n-1) return true;
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(nr >=0 && nc >=0 && nr <n && nc < n && !vis[nr][nc] && dis[nr][nc] >= m){
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        return false;
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