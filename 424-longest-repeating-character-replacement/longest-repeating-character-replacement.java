class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int l =0;
        int r = 0;
        int ans = 0;
        int maxFreq = 0;
        while(r < n){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            if((r-l+1) - maxFreq > k){
                char c2 = s.charAt(l);
                map.put(c2, map.get(c2) - 1);
                l++;
            }
            if((r-l+1) - maxFreq <= k){
                ans = Math.max(ans, r - l + 1);
            }
            r++;
        }
        return ans;
    }
}