class Solution {
    public String breakPalindrome(String p) {
        int n = p.length();
        if(n == 1) return "";

        char[] c = p.toCharArray();
        for(int i =0;i<n/2;i++){
            if(c[i] != 'a'){
                c[i] = 'a';
                return new String(c);
            }
        }
        c[n-1] = 'b';
        return new String(c);
    }
}