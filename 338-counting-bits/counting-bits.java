class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i =0;i<=n;i++){
            ans[i] = countOne(i);
        }
        return ans;
    }

    public int countOne(int n) {
        int ans = 0;
        while(n > 0){
            ans+= n %2;
            n /= 2;
        }
        return ans;
    }
}