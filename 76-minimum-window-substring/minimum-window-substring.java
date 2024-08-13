class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int n = s.length();
        int m = t.length();
        for(int i =0;i<m;i++) {
            hash[t.charAt(i) - 'A']++;
        }
        int l =0;
        int r =0;
        int si = -1;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        while(r < n){
            char c = s.charAt(r);
            if(hash[c - 'A'] > 0) cnt++;
            hash[c - 'A']--;
            while(cnt == m){
                int len = r - l + 1;
                if(minLen > len){
                    minLen = len;
                    si = l;
                }
                char c2 = s.charAt(l);
                hash[c2 - 'A']++;
                if(hash[c2 - 'A'] > 0) cnt--;
                l++;
            }
            r++;
        }
        return (si == -1) ? "" : s.substring(si, si + minLen);
    }
}