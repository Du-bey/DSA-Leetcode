class Solution {
    HashMap<String, Boolean> h = new HashMap<>();

    public boolean wordBreak(String s, List<String> words) {
        Set<String> set = new HashSet<>();
        for (String st : words) {
            set.add(st);
        }

        return set.contains(s) || isConcatenated(s, set);
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