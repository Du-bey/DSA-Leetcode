class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int highestNeg = Integer.MAX_VALUE;
        int negCnt = 0;
        long sum = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int u = matrix[i][j];
                if(u < 0){
                    negCnt++;
                }
                highestNeg = Math.min(highestNeg, Math.abs(u));
                sum += Math.abs(u);
            }
        }
        if(negCnt % 2 != 0){
            highestNeg = Math.abs(highestNeg);
            sum -= 2 * highestNeg;
        }
        
        return sum;
    }
}
