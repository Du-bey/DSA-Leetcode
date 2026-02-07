class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int acnt = 0;
        int bcnt = 0;

        for(char c : s.toCharArray()){
            if(c == 'a') acnt++;
        }

        int ans = n-1;
        
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'a') acnt--;
            ans = Math.min(ans, acnt + bcnt);
            if(ch == 'b') bcnt++;
        }

        return ans;
    }
}