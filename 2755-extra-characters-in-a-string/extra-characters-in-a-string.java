class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> d = new HashSet<>();
        for(String s1 : dictionary) d.add(s1);
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, d, s, dp);
    }

    public int f(int i, HashSet<String> d, String s, int[] dp){
        int n = s.length();
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = 1 + f(i+1, d, s, dp);
        String t = "";
        for(int j =i;j<n;j++){
            t += s.charAt(j);
            if(d.contains(t)){
                dp[i] = Math.min(dp[i], f(j + 1, d, s, dp));
            }
        }
        return dp[i];
    }
}