class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int car = 0;
        int n = a.length();
        int m = b.length();
        int i = n-1;
        int j = m-1;
        while(i >= 0 || j >= 0){
            int sum = car;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            car = sum > 1 ? 1 : 0;
            char c = (char)(sum % 2 + '0');
            ans = c + ans;
        }
        if(car == 1){
            ans = "1" + ans;
        }
        return ans;
    }
}