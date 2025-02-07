class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        int n = digits.length;
        for(int i = n-1;i>=0;i--){
            int num = digits[i];
            num = num + c;
            c = num / 10;
            num = num % 10;
            digits[i] = num;
        }
        if(c > 0){
            int[] ans = new int[n+1];
            ans[0] = 1;
            for(int i =0;i<n;i++){
                ans[i+1] = digits[i];
            }
            return ans;
        }
        return digits;
    }
}