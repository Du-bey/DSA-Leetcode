class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> d = new HashSet<>();
        for(String s1 : dictionary) d.add(s1);
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i = n-1;i>=0;i--){
            dp[i] = 1 + dp[i+1];
            String t = "";
            for(int j =i;j<n;j++){
                t += s.charAt(j);
                if(d.contains(t)){
                    dp[i] = Math.min(dp[i], dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}