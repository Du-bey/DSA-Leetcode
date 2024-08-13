class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n ==1) return n;
        HashMap<Character, Integer> h = new HashMap<>();
        int l = 0;
        int ans = 0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(h.containsKey(c)){
                ans = Math.max(i-l, ans);
                l = Math.max(h.get(c) + 1, l);
            }
            h.put(c, i);
            ans = Math.max(i-l+1, ans);
        }
        return ans;
    }
}