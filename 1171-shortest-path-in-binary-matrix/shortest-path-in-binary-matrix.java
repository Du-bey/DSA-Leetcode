class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new tuple(1, 0, 0));
        int[][] dis = new int[n][n];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<n;j++) {
                dis[i][j] = (int) 1e9;
            }
        }
        dis[0][0] = 1;
        //grid[0][0] = -1;
        while(!pq.isEmpty()){
            tuple t = pq.poll();
            int d = t.first;
            int r = t.second;
            int c = t.third;
            if(r == n-1 && c == n-1) return d;
            for(int i =0;i<8;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];
                if(newr >=0 && newc >=0 && newr <n && newc <n && grid[newr][newc] == 0){
                    if(dis[newr][newc] > d+1){
                        dis[newr][newc] = d + 1;
                        pq.add(new tuple(dis[newr][newc], newr, newc));
                        //grid[newr][newc] = -1;
                    }
                }
            }
        }
        return -1;
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