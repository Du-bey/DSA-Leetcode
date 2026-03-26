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
            }
            sum += rsum[i];
        }

        for(int j =0;j<m;j++){
            for(int i = 0;i<n;i++){
                csum[j] += grid[i][j];
            }
        }

        long st = rsum[0];
        for(int i = 1;i<n;i++){
            if(st == (sum - st)) return true;
            st += rsum[i];
        }

        st = csum[0];
        for(int j =1;j<m;j++){
            if(st == (sum - st)) return true;
            st +=csum[j];
        }
        return false;
    }
}