class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;

        for(int i =0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(possible(words[i], words[j])){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public boolean possible(String s, String t){
        int n = s.length();
        int m = t.length();

        if(n != m + 1) return false;
        boolean dif = false;
        int i = 0, j = 0;
        while(j < m){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else if(dif){
                return false;
            }
            else{
                dif = true;
                i++;
            }
        }
        return true;
    }
}