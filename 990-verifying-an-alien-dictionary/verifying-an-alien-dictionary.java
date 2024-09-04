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
            int min = Math.min(s.length(), t.length());
            boolean dif = false;
            for(int ind = 0;ind < min;ind++){
                
                char c1 = s.charAt(ind);
                char c2 = t.charAt(ind);
                if(c1 != c2){
                    dif = true;
                    if(h.get(c1) > h.get(c2)){
                        System.out.println(c1 + " " + c2);
                        return false;
                    }
                    break;
                }
            }
            if(!dif && t.length() == min && s.length() > min) return false;
        }
        return true;
    }
}