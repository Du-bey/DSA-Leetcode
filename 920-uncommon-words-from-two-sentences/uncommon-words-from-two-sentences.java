class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] aWords = s1.split(" ");
        String[] bWords = s2.split(" ");
        HashMap<String, Integer> h = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String s : aWords){
            h.put(s, h.getOrDefault(s, 0) + 1);
        }
        for(String s : bWords){
            h.put(s, h.getOrDefault(s, 0) + 1);
        }
        for(String s : h.keySet()){
            if(h.get(s) == 1) ans.add(s);
        }
        return ans.toArray(new String[0]);
    }
}