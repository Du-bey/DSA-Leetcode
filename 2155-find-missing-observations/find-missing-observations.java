class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for(int r : rolls){
            sum += r;
        }
        int asum = mean * (n+m);
        int rsum = asum - sum;
        int high = n*6;
    
        if(rsum > high || rsum < n) return new int[0];
        int[] ans = new int[n];
        int no = rsum / n;
        int rem = rsum % n;
        Arrays.fill(ans, no);
        for (int i = 0; i < rem; i++)
            ans[i]++;
        return ans;
    }
}