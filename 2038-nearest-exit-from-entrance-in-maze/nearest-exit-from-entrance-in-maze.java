class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int x = entrance[0];
        int y = entrance[1];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, x, y});
        boolean[][] vis = new boolean[n][m];
        vis[x][y] = true;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int d = arr[0];
            int r = arr[1];
            int c = arr[2];

            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nc >=0 && nr < n && nc < m && !vis[nr][nc] && maze[nr][nc] != '+'){
                    if(nr == 0 || nc == 0 || nr == n-1 || nc == m-1) return d+1;
                    vis[nr][nc] = true;
                    q.add(new int[]{d + 1, nr, nc});
                }
            }
        }
        return -1;
    }
}