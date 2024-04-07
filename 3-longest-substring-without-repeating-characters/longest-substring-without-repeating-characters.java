class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n ==1) return n;
        int l =0;
        int ans = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int r =0;r<n;r++){
            char c = s.charAt(r);
            if(h.containsKey(c)){
                l = Math.max(h.get(c) + 1, l);
            }
            h.put(c, r);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}