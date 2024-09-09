class Solution {
    public int[][] generateMatrix(int n) {
        int m = n;
        int cnt = 1;

        int[][] matrix = new int[n][m];
        int top = 0;
        int left = 0;
        int right = m-1;
        int bottom = n-1;
        while(top <= bottom && left <= right){
            for(int i =left;i<=right;i++){
                matrix[top][i] = cnt++;
            }
            top++;
            for(int i =top;i<=bottom;i++){
                matrix[i][right]= cnt++;
            }
            right--;
            if(top <= bottom){
                for(int i =right;i>=left;i--){
                    matrix[bottom][i]= cnt++;
                }
                bottom--;
            }
            
            if(left <= right){
                for(int i =bottom;i>=top;i--){
                    matrix[i][left]= cnt++;
                }
                left++;
            }
        }
        return matrix;
    }
}