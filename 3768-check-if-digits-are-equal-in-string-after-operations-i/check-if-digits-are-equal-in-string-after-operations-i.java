class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for(int i =1;i<n;i++){
                int a = s.charAt(i) - '0';
                int b = s.charAt(i-1) - '0';
                int d = a + b;
                d %= 10;
                sb.append((char) (d + '0'));
            }
            
            s = sb.toString();
        }

        return (s.length() == 2 && s.charAt(0) == s.charAt(1));
    }
}