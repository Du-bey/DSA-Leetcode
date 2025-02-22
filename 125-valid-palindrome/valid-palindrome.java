class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        s = sb.toString();
        
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}