class Solution {
    HashMap<String, Boolean> h = new HashMap<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }
        HashMap<String, Boolean> h = new HashMap<>();

        List<String> ans = new ArrayList<>();
        for (String s : words) {
            if(isConcatenated(s, set)){
                ans.add(s);
            }
        }
        return ans;
    }

    public boolean isConcatenated(String s, Set<String> set){
        if(h.get(s) != null) return h.get(s);
        for(int i =0;i<s.length();i++){
            String pre = s.substring(0, i+1);
            String suf = s.substring(i+1);

            if(set.contains(pre) && set.contains(suf) || (set.contains(pre) && isConcatenated(suf, set))){
                h.put(s, true);
                return true;
            }
        }
        h.put(s, false);
        return false;
    }
}
