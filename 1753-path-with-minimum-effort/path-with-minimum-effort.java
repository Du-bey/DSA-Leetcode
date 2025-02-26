class Solution {
    public int minimumEffortPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new tuple(0, 0, 0));
        int[][] dis = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dis[i][j] = (int) 1e9;
            }
        }
        dis[0][0] = 0;
        while(!pq.isEmpty()){
            tuple t = pq.poll();
            int d = t.first;
            int r = t.second;
            int c = t.third;
            if(r == n-1 && c == m-1) return d;
            for(int i =0;i<4;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];
                if(newr >=0 && newc >=0 && newr <n && newc <m){
                    int newEff = Math.max(Math.abs(grid[newr][newc] - grid[r][c]), d);
                    if(dis[newr][newc] > newEff){
                        dis[newr][newc] = newEff;
                        pq.add(new tuple(newEff, newr, newc));
                    }
                }
            }
        }
        return 0;
    }
}

class tuple {
    int first, second, third;
    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}