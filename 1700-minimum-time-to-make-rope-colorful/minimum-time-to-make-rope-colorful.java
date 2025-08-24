class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = colors.length();
        int i = 0;
        int j = 1;
        while(j < n){
            char cj = colors.charAt(j);
            char ci = colors.charAt(i);
            if(cj == ci){
                int ni = neededTime[i];
                int nj = neededTime[j];
                if(ni < nj){
                    i = j;
                }
                ans += Math.min(ni, nj);
            }
            else{
                i = j;
            }
            j++;
        }
        return ans;
    }
}