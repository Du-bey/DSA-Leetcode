class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        int score = 0;
        
        for(int i =0;i<n;i++){
            int s = 0;
            for(int j=0;j<n;j++){
                s += grid[i][j];
            }
            if(s > score){
                score = s;
                ans = i;
            }
        }
        return ans;
    }
}