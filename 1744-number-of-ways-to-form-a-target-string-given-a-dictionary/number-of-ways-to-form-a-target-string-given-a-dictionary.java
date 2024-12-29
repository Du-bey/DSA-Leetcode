class Solution {
    int MOD=1000000007;
    public int numWays(String[] words, String target) {
        int n = words.length;
        int wordLen = words[0].length();
        int m = target.length();

        int[][] dp = new int[wordLen][m];
        int[][] freq = new int[wordLen][26];

        for (String word : words) {
            for (int j = 0; j < wordLen; j++) {
                int character = word.charAt(j) - 'a';
                freq[j][character]++;
                freq[j][character] %= MOD;
            }
        }
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return (int) f(words, target, 0, 0, dp, freq);
    }

    public long f(String[] words, String target, int j, int k, int[][] dp, int[][] freq){
        if(k == target.length()) return 1;
        if(j == words[0].length()) return 0;

        if(dp[j][k] != -1) return dp[j][k];
        
        long take = 0;

        int curPos = target.charAt(k) - 'a';
        char c = target.charAt(k);

        long rest = f(words, target, j+1, k+1, dp, freq);
        rest %= MOD;
        take += freq[j][curPos] * rest;
        take %= MOD;
        
        long notTake = f(words, target, j+1, k, dp, freq);
        notTake %= MOD;
        long ans = (take + notTake) % MOD;
        dp[j][k] = (int) (ans);
        return ans;
    }
}