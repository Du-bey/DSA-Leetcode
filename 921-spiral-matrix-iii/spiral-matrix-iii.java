class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
        int n = rows * cols;
        int[][] dirt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][2];
        int len = 0, d = 0, j = 0;
        res[j++] = new int[]{r,c};
        while(j < n){
            if(d == 0 || d == 2) len++;
            for(int i =0;i<len;i++){
                r += dirt[d][0];
                c += dirt[d][1];
                if(r >= 0 && c >= 0 && r < rows && c < cols){
                    res[j++] = new int[]{r,c};
                }
            }
            d = (d+1) % 4;
        }
        return res;
    }
}