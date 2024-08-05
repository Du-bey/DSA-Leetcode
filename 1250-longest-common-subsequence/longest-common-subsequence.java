class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int n = t1.length();
        int m = t2.length();
        int[] prev = new int[m+1];
        for(int i =0;i<=n;i++){
            int[] cur = new int[m+1];
            for(int j =0;j<=m;j++){
                if(i == 0 || j == 0){
                    cur[j] = 0;
                }
                else{
                    if(t1.charAt(i-1) == t2.charAt(j-1)){
                        cur[j] = 1 + prev[j-1];
                    }
                    else{
                       cur[j] = Math.max(prev[j], cur[j-1]);
                    }
                }
            }
            prev = cur;
        }
        return prev[m];
    }
}