class Solution {
    public boolean isSubsequence(String s, String t) {
        int tl = t.length();
        int sl = s.length();
        int j = 0;
        if(sl == 0) return true;
        for(int i =0;i<tl;i++){
            if(s.charAt(j) == t.charAt(i)) j++;
            if(j == sl) return true;
        }
        return false;
    }
}