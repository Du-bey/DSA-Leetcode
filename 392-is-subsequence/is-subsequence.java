class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = n-1;
        int j = m-1;

        while(i >= 0 && j >= 0){
            if(s.charAt(i) == t.charAt(j)) i--;
            j--;
        }
        return i < 0;
    }
}