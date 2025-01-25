class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        int st = 0;
        int[][] dp = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                if(f(s, i, j)){
                    if((j - i + 1) > len){
                        len = j - i + 1;
                        st = i;
                    }
                }
            }
        }
        return s.substring(st, st + len);
    }

    public boolean f(String s, int i, int j){
        if(i >= j) return true;
        if(s.charAt(i) == s.charAt(j)){
            return f(s, i+1, j-1);
        }
        return false;
    }
}