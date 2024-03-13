class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int l = 0;
        int h = m -1;
        int[] ans = new int[2];
        while(l <= h){
            int mid = (l+h)/2;
            int row = findMax(mat, n, m, mid);
            int left = mid - 1 > 0 ? mat[row][mid-1] : -1;
            int right = mid < m-1 ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                ans[0] = row;
                ans[1] = mid;
                return ans;
            }
            else if(mat[row][mid] < left){
                h = mid - 1;
            }
            else{
                l = mid +1;
            }
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }
    public static int findMax(int[][] mat, int n, int m, int mid){
        int max = -1;
        int mi = -1;
        for(int i =0;i<n;i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                mi = i;
            }
        }
        return mi;
    }
    
}