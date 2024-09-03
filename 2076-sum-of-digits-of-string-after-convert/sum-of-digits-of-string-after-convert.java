class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        long sum = 0;
        for(int i =0;i<n;i++){
            int val = s.charAt(i) - 'a' + 1;
            if(val > 9){
                int realval = 0;
                realval = val%10;
                val /= 10;
                realval += val%10;
                val = realval;
            }
            sum = sum + val;
        }
        k--;
        if(k == 0) return (int)sum;
        long ans = 0;
        for(int i =0;i<k;i++){
            ans = 0;
            while(sum > 0){
                int dig = ((int)sum) %10;
                ans += dig;
                sum = sum / 10;
            }
            sum = ans;
        }
        return (int)ans;
    }
}