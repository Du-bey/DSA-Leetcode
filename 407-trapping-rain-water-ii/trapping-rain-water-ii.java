class Solution {
    public int trapRainWater(int[][] h) {
        int n = h.length;
        int m = h[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<Trip> pq = new PriorityQueue<>((a, b) -> a.a - b.a);
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    vis[i][j] = true;
                    pq.add(new Trip(h[i][j], i, j));
                }
            }
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int ans = 0;

        while(!pq.isEmpty()){
            Trip t = pq.poll();
            int height = t.a;
            int i = t.b;
            int j = t.c;
            
            for(int ind = 0;ind<4;ind++){
                int nr = i + dr[ind];
                int nc = j + dc[ind];
                if(nr >= 0 && nc >=0 && nr < n && nc < m && !vis[nr][nc]){
                    ans += Math.max(height - h[nr][nc], 0);
                    pq.add(new Trip(Math.max(h[nr][nc], height), nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        return ans;
    }
}

class Trip{
    int a;
    int b;
    int c;
    public Trip(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}