class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        if(n == 0) return ans;
        HashMap<String, List<String>> h = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            int[] freq = new int[26];
            for(char ch : c){
                freq[ch - 'a']++;
            }
            String t = Arrays.toString(freq);
            h.putIfAbsent(t, new ArrayList<>());
            h.get(t).add(s);
        }
        return new ArrayList<>(h.values());
    }
}