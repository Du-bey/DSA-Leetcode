class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for(char c : s.toCharArray()){
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        List<Character> l = new ArrayList(h.keySet());
        Collections.sort(l, (a, b) -> h.get(b) - h.get(a));
        StringBuilder sb = new StringBuilder();
        for(Character c : l){
            for(int i =0;i<h.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}