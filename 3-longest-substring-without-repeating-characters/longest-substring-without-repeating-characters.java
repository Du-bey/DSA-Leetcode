class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        int ans = 0;
        for(int r = 0;r< n;r++){
            char c = s.charAt(r);
            while(h.containsKey(c)){
                char ch = s.charAt(l);
                h.put(ch, h.get(ch) - 1);
                if(h.get(ch) <= 0) h.remove(ch);
                l++;
            }
            h.put(c, h.getOrDefault(c, 0) + 1);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}