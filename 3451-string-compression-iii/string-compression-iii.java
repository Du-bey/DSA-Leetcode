class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        
        for(int i =0;i<n;i++){
            char ch = word.charAt(i);
            int cnt = 0;
            while(i < n && word.charAt(i) == ch && cnt < 9){
                cnt++;
                i++;
            }
            i--;
            sb.append(cnt);
            sb.append(ch);
        }
        return sb.toString();
    }
}