class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int r = 0;
        int c = m - 1;
        while(r < n && c >= 0){
            int mid = matrix[r][c];
            if(mid == target) return true;
            if(mid > target) c--;
            else r++;
        }
        return false;
    }
}