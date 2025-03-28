class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int n = mat.length;
        int m = mat[0].length;
        Queue<Triplet> q = new LinkedList<>();

        int[][] ans = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Triplet(0, i, j));
                }
            }
        }
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int dis = t.first;
            int r = t.second;
            int c = t.third;

            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == 1 && ans[nr][nc] == 0){
                    q.add(new Triplet(dis + 1, nr, nc));
                    ans[nr][nc] = dis + 1;
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