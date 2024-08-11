class Solution {
    public int lengthOfLIS(int[] num) {
        int n = num.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1;i<n;i++){
            for(int j =0;j<i;j++){
                if(num[j] < num[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}