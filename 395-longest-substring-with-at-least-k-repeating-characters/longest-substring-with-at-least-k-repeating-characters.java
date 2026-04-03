class Solution {
    public int longestSubstring(String s, int k, int x) {
        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        int ans = 0;
        while(r < n){
            char cr = s.charAt(r);
            h.put(cr, h.getOrDefault(cr, 0) + 1);

            while(h.size() > x){
                char cl = s.charAt(l);
                h.put(cl, h.get(cl) - 1);
                if(h.get(cl) <= 0) h.remove(cl);
                l++;
            }
            boolean pos = true;
            for(int val : h.values()){
                if(val < k){
                    pos = false;
                    break;
                }
            }
            if(pos) ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public int longestSubstring(String s, int k) {
        int ans = 0;
        for(int i =1;i<=Math.min(26, s.length());i++){
            ans = Math.max(ans, longestSubstring(s, k, i));
        }
        return ans;
    }
}



// find longest substring which contains only x characters and those characters should repeat at least k times