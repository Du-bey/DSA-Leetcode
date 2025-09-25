class NumMatrix {
    int[][] s;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        s = new int[n+1][m+1];

        for(int i = 0;i<n;i++){
            int pre = 0;
            for(int j =0;j<m;j++){
                pre += matrix[i][j];
                int above = s[i][j+1];
                s[i+1][j+1] = pre + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int br = s[row2][col2];
        int tr = s[row1-1][col2];
        int tl = s[row1-1][col1-1];
        int bl = s[row2][col1-1];
        return br - tr - bl + tl;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */