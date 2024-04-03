class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int max = 1;
        int n = words.length;
        int[] dp = new int[n];
        for(int i =0;i<n;i++){
            dp[i] = 1;
        }
        for(int i =0;i<n;i++){
            for(int prev = 0;prev < i;prev++){
                if(checkString(words[i], words[prev])){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public boolean checkString(String s, String p){
        char[] cur = s.toCharArray();
        char[] prev = p.toCharArray();
        int a = cur.length;
        int b = prev.length;
        int cnt = 0;
        
        if(a - 1 != b) return false;
        int i =0;
        int j =0;
        while(i < a){
            if(j < b && cur[i] == prev[j]){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j == b && i == a;
    }
}