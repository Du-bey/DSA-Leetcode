class Solution {
    public String largestGoodInteger(String num) {
        char last = ' ';
        int n = num.length();
        for(int i =2;i<n;i++){
            char c = num.charAt(i);
            if(c == num.charAt(i-1) && c == num.charAt(i-2)){
                last = (char) Math.max(last, c);
            }
        }

        if(last == ' ') return "";
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<3;i++){
            sb.append(last);
        }
        return sb.toString();
    }
}