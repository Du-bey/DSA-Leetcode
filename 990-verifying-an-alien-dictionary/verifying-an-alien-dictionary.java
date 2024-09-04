class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> h = new HashMap<>();
        int ol = order.length();
        for(int i =0;i<ol;i++){
            char c = order.charAt(i);
            h.put(c, i);
        }
        int n = words.length;

        for(int i =0;i<n-1;i++){
            String s = words[i];
            String t = words[i+1];
            int w1 = s.length();
            int w2 = t.length();
            for(int j =0;j<w1;j++){
                if(j == w2) return false;
                char c1 = s.charAt(j);
                char c2 = t.charAt(j);
                if(c1 != c2){
                    if(h.get(c1) > h.get(c2)){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}