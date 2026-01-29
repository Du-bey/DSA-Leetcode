class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int ans = 0;
        boolean first = true;
        int zero = 0;

        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == '0'){
                if(first){
                    first = false;
                    zero++;
                }
            }
            else{
                first = true;
                ans += zero;
            }
        }
        return ans;
    }
}