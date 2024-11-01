class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i =n-1;i>=0;i--){
            char c = num.charAt(i);
            int x = c - '0';
            if(x % 2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}