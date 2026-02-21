class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        int i = n-1;
        int j = m-1;
        int car = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            if(i >= 0){
                car += a.charAt(i--) - '0';
            }
            if(j >= 0){
                car += b.charAt(j--) - '0';
            }

            sb.append((char)((car % 2) + '0'));
            car /= 2;
        }
        if(car > 0) sb.append('1');

        return sb.reverse().toString();
    }
}