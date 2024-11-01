class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for(int i = n-1;i>=0;i--){
            if(c[i] == ' '){
                if(temp.equals("")) continue;
                sb.append(temp);
                sb.append(' ');
                temp = "";
            }
            else{
                temp = c[i] + temp;
            }
        }
        sb.append(temp);
        return sb.toString(); 
    }
}