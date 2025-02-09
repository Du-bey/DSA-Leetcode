class Solution {
    public int nthUglyNumber(int n) {
        if(n < 6) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int a =0, b=0, c=0;
        for(int i =1;i<n;i++){
            int two = dp[a] * 2;
            int three = dp[b] * 3;
            int five = dp[c] * 5;
            dp[i] = Math.min(two, Math.min(three, five));
            if(dp[i] == two) a++;
            if(dp[i] == three) b++;
            if(dp[i] == five) c++;
        }
        return dp[n-1];
    }
}