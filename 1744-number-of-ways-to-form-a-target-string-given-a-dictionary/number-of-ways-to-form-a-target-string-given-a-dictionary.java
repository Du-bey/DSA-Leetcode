class Solution {
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = target.length();
        int len = words[0].length();
        long[][] dp = new long[len + 1][m + 1];
        int MOD=1000000007;

        for(int i =0;i<=len;i++){
            dp[i][m] = 1;
        }

        int[][] freq = new int[len][26];
        for (String word : words) {
            for (int j = 0; j < len; j++) {
                int character = word.charAt(j) - 'a';
                freq[j][character]++;
                freq[j][character] %= MOD;
            }
        }

        for(int j = len - 1;j >=0; j--){
            for(int k = m - 1; k>=0; k--){
                long take = 0;
                int curPos = target.charAt(k) - 'a';
                char c = target.charAt(k);
                long rest = dp[j+1][k+1];
                rest %= MOD;
                take += (freq[j][curPos] * rest) % MOD;
                take %= MOD;
                    
                long notTake = dp[j+1][k];
                notTake %= MOD;
                long ans = (take + notTake) % MOD;
                dp[j][k] = (int) (ans);
            }
        }
        return (int) dp[0][0];
    }
}