class Solution {
    public boolean isSubsequence(String s, String t) {
        int tl = t.length();
        int sl = s.length();
        int j = 0;
        char ss[] = s.toCharArray();
        char tt[] = t.toCharArray();
        if(sl == 0) return true;
        for(int i =0;i<tl;i++){
            if(ss[j] == tt[i]) j++;
            if(j == sl) return true;
        }
        return false;
    }
}