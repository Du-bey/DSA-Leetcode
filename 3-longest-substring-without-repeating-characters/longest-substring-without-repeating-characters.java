class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        int ans = 0;
        for(int r = 0;r< n;r++){
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