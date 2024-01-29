class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<tuple> q = new PriorityQueue<tuple>((x, y) -> x.first - y.first);
        int[][] dis = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dis[i][j] = (int)(1e9);
            }
        }
        dis[0][0] = 0;
        q.add(new tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            tuple it = q.peek();
            q.remove();
            int d = it.first;
            int r = it.second;
            int c = it.third;

            if(r == n-1 && c == m-1) return d;

            for(int i =0;i<4;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr >= 0 && newr < n && newc >= 0 && newc < m) {
                    int newEffort = Math.max(Math.abs(heights[newr][newc] - heights[r][c]), d);
                    if(newEffort < dis[newr][newc]){
                        dis[newr][newc] = newEffort;
                        q.add(new tuple(newEffort, newr, newc));
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