class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] a = new int[m][n];

        for(int[] arr : walls){
            int u = arr[0];
            int v = arr[1];
            a[u][v] = -1;
        }

        for(int[] arr : guards){
            int u = arr[0];
            int v = arr[1];
            a[u][v] = 3;
        }

        for(int[] arr : guards){
            int u = arr[0];
            int v = arr[1];
            for(int i = u+1;i<m;i++){
                if(a[i][v] == 3) break;
                if(a[i][v] != -1){
                    a[i][v] = 2;
                }
                else break;
            }
            for(int i = u-1;i>=0;i--){
                if(a[i][v] == 3) break;
                if(a[i][v] != -1){
                    a[i][v] = 2;
                }
                else break;
            }
            for(int i = v+1;i<n;i++){
                if(a[u][i] == 3) break;
                if(a[u][i] != -1){
                    a[u][i] = 2;
                }
                else break;
            }
            for(int i = v-1;i>=0;i--){
                if(a[u][i] == 3) break;
                if(a[u][i] != -1){
                    a[u][i] = 2;
                }
                else break;
            }
        }
        int ans = 0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(a[i][j] == 0) ans++;
            }
        }
        return ans;
    }
}