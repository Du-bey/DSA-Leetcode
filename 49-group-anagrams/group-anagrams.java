class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        if(n == 0) return ans;
        Map<String, List<String>> h = new HashMap<>();
        for(String s : strs){
            char[] c = new char[26];
            for (char ch : s.toCharArray()) c[ch - 'a']++;
            String t = String.valueOf(c);
            if(h.containsKey(t)){
                List<String> list = h.get(t);
                list.add(s);
                h.put(t, list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                h.put(t, list);
            }
        }
        return new ArrayList<>(h.values());
    }
}