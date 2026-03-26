class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long sum = 0;

        long[] rsum = new long[n];
        long[] csum = new long[m];

        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                rsum[i] += grid[i][j];
                csum[j] += grid[i][j];
                sum += grid[i][j];
            }
        }

        if(sum % 2 != 0) return false;

        long st = 0;
        for(int i = 0;i<n-1;i++){
            st += rsum[i];
            if(st == (sum - st)) return true;
        }

        st = 0;
        for(int j =0;j<m-1;j++){
            st += csum[j];
            if(st == (sum - st)) return true;
        }

        return false;
    }
}