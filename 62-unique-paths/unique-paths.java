class Solution {
    
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);

        for(int i = 1;i<m;i++){
            int[] cur = new int[n];
            cur[0] = 1;
            for(int j = 1; j<n;j++){
                cur[j] = prev[j] + cur[j-1];
            }
            prev = cur;
        }   
        return prev[n-1];
    }
}