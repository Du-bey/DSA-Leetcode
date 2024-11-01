class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        String a = strs[0];
        String b = strs[1];
        int len = Math.min(a.length(), b.length());
        for(int i =0;i<len;i++){
            if(a.charAt(i) == b.charAt(i)){
                sb.append(a.charAt(i));
            }
            else break;
        }
        if(sb.toString().equals("")) return "";
        for(int i =2;i<n;i++){
            String a1 = sb.toString();
            String b1 = strs[i];
            if(b1.equals("")) return b1;
            int len1 = Math.min(a1.length(), b1.length());
            for(int i1 =0;i1<len1;i1++){
                if(a1.charAt(i1) != b1.charAt(i1)){
                    sb.setLength(i1);
                    break;
                }
            }
            sb.setLength(Math.min(len1, sb.length()));
        }
        return sb.toString();
    }
}