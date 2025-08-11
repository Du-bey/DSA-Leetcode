class Solution {
    public String reverseWords(String s) {
        String[] sw = s.trim().split("\\s+");
        int n = sw.length;
        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i>0;i--){
            sb.append(sw[i]);
            sb.append(" ");
        }
        sb.append(sw[0]);
        return sb.toString();
    }
}