class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n != m) return false;
        int cnt = 0;
        int a=-1, b=-1;
        for(int i =0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
                if(a == -1) a = i;
                else if(b == -1) b = i;
            }
        }
        if(cnt == 0) return true;
        if(cnt == 2 && s1.charAt(a) == s2.charAt(b) && s2.charAt(a) == s1.charAt(b)) return true;
    
        return false;
    }
}