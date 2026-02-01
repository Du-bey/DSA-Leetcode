class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1, 0, 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int d = t.first;
            int r = t.second;
            int c = t.third;

            if(r == n-1 && c == n-1) return d;

            for(int i =0;i<8;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >=0 && nc >=0 && nr <n && nc < n && grid[nr][nc] == 0){
                    grid[nr][nc] = 1;
                    q.add(new Tuple(d+1, nr, nc));
                }
            }
        }
        return -1;
    }
}

class Tuple {
    int first, second, third;
    Tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}