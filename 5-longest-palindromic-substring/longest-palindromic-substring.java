class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int st = 0;
        int len = 0;
        for(int i =0;i<n;i++){
            int l =i, r =i;
            while(l >= 0 && r <n && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > len){
                    len = r - l + 1;
                    st = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r <n && s.charAt(l) == s.charAt(r)){
                if((r - l + 1) > len){
                    len = r - l + 1;
                    st = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(st, st+len);
    }
}