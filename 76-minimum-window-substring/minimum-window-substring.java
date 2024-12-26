class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] freq = new int[256];
        for(int i = 0;i<m;i++){
            freq[t.charAt(i) - 'A']++;
        }
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int si = -1;
        int cnt = 0;
        while(r < n){
            char c = s.charAt(r);
            if(freq[c - 'A'] > 0) cnt++;
            freq[c - 'A']--;
            while(cnt == m){
                int len = r - l + 1;
                if(minLen > len){
                    minLen = len;
                    si = l;
                }
                char c2 = s.charAt(l);
                freq[c2 - 'A']++;
                if(freq[c2 - 'A'] > 0) cnt--;
                l++;
            }
            r++;
        }
        return (si == -1) ? "" : s.substring(si, si + minLen);
    }
}