class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int min = Integer.MAX_VALUE;
        int si = -1;
        int l =0;
        int cnt = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i =0;i<m;i++){
            char c = t.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        for(int r =0;r <n;r++){
            char c = s.charAt(r);
            if(h.containsKey(c)){
                if(h.get(c) > 0){
                    cnt++;
                }
            }
            h.put(c, h.getOrDefault(c, 0) - 1);
            while(cnt == m){
                if(r-l+1 < min){
                    min = r-l+1;
                    si = l;
                } 
                char lc = s.charAt(l);
                h.put(lc, h.get(lc) +1);
                if(h.get(lc) > 0) cnt--;
                l++;
            }
        }

        return (si == -1) ? "" : s.substring(si, si + min);
    }
}