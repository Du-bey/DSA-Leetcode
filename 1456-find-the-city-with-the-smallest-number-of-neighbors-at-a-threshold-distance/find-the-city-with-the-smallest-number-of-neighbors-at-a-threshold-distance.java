class Solution {
    public int findTheCity(int n, int[][] edges, int dis) {
        int[][] mat = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i == j) mat[i][j] = 0;
                else
                mat[i][j] = (int) 1e9;
            }
        }
        for(int[] r : edges){
            int u = r[0];
            int v = r[1];
            int d = r[2];
            mat[u][v] = d;
            mat[v][u] = d;
        }
        for(int via = 0;via<n;via++){
            for(int i = 0;i<n;i++){
                for(int j =0;j<n;j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }
        int city = (int) 1e9;
        int ans = 0;
        for(int i =0;i<n;i++){
            int t = 0;
            for(int j =0;j<n;j++){
                if(mat[i][j] <= dis && i != j) t++;
            }
            if(t <= city){
                city = t;
                ans = i;
            }
        }
        return ans;
    }
}