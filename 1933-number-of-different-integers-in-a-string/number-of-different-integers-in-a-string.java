class Solution {
    public int numDifferentIntegers(String word) {
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        HashSet<String> h = new HashSet<>();
        for(int i =0;i<n;i++){
            char ch = word.charAt(i);
            if(ch - '0' >= 0 && ch - '0' < 10) sb.append(ch);
            else{
                String s = sb.toString();
                if(!s.equals("")) h.add(s.replaceAll("^0*", ""));
                sb.setLength(0);
            }
        }
        String s = sb.toString();
        if(!s.equals("")) h.add(s.replaceAll("^0*", ""));
        return h.size();
    }
}