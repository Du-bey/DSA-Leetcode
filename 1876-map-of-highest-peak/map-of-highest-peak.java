class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] ans = new int[n][m];
        for(int[] r : ans){
            Arrays.fill(r, 100000000);
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Triplet> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(isWater[i][j] == 1){
                    q.add(new Triplet(0, i, j));
                    ans[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            Triplet t = q.poll();
            int d = t.first;
            int r = t.second;
            int c = t.third;
            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc] && isWater[nr][nc] == 0){
                    q.add(new Triplet(d + 1, nr, nc));
                    ans[nr][nc] = d + 1;
                    vis[nr][nc] = true;
                }
            }
        }
        return ans;
    }
}

public class Triplet {
    int first;
    int second;
    int third;

    public Triplet(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}