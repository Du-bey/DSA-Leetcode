class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n ==1) return n;
        int l =0;
        int r =0;
        int ans = 1;
        int len = 1;
        HashMap<Character, Integer> h = new HashMap<>();
        h.put(s.charAt(0), 0);
        while(r < n-1){
            char rc = s.charAt(r+1);
            if(!h.containsKey(rc)){
                len++;
                ans = Math.max(ans, len);
                h.put(rc, r+1);
                r++;
            }
            else{
                int ind = h.get(rc);
                while(l <= ind){
                    h.remove(s.charAt(l));
                    l++;
                    len--;
                }
            }
        }
        return ans;
    }
}