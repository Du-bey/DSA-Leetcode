class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        HashMap<String, Integer> h = new HashMap<>();

        for(int r = 0; r < n; r++){
            sb.append(s.charAt(r));
            while(sb.length() > 10){
                sb.deleteCharAt(0);
            }
        
            if(sb.length() == 10){
                String s1 = sb.toString();
                h.put(s1, h.getOrDefault(s1, 0) + 1);
            }
        }

        for(String k : h.keySet()){
            int val = h.get(k);
            if(val > 1) ans.add(k);
        }
        return ans;
    }
}