class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        long ans = 0;
        int negCnt = 0;
        int highestNeg = Integer.MAX_VALUE;

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                int u = matrix[i][j];
                if(u < 0){
                    negCnt++;
                }
                highestNeg = Math.min(highestNeg, Math.abs(u));
                ans += Math.abs(u);
            }
        }

        if(negCnt %2 != 0){
            ans -= 2 * highestNeg;
        }
        
        return ans;
    }
}