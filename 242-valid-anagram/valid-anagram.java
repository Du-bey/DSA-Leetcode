class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(h.containsKey(c)){
                int freq = h.get(c);
                freq = freq + 1;
                h.put(c, freq);
            }
            else{
                h.put(c, 1);
            }
        }

        for(int i =0;i<n;i++){
            char c = t.charAt(i);
            if(h.containsKey(c)){
                int freq = h.get(c);
                freq = freq - 1;
                if(freq == 0) h.remove(c);
                else{
                    h.put(c, freq);
                }
            }
            else{
                return false;
            }
        }
        return h.isEmpty();
    }
}