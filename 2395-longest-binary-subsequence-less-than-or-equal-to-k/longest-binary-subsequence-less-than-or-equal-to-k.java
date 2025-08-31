class Solution {
    public int longestSubsequence(String s, int k) {
        char[] ch = s.toCharArray();
        int ans = 0, ind = 0;
        long num = 0;
        int n = ch.length;
        
        for(int i = n-1; i>=0;i--){
            if(num <= k){
                if(ch[i] == '1'){
                    num += (int)Math.pow(2, ind);
                }
                if(num <= k) ans++;
            }
            else{
                if(ch[i] == '0') ans++;
            }
            ind++;
        }
        
        return ans;
    }
}