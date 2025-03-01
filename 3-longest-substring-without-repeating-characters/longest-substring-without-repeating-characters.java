class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int ans = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int r = 0;r < n;r++){
            char c = s.charAt(r);
            if(h.containsKey(c)){
                l = Math.max(l, h.get(c) + 1);
            }
            h.put(c, r);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}