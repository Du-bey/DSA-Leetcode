class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int h = m*n - 1;

        while(l <= h){
            int mid = (l + h) / 2;
            int x = mid / m;
            int y = mid % m;
            int no = matrix[x][y];
            if(no == target) return true;
            if(no > target) h = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}