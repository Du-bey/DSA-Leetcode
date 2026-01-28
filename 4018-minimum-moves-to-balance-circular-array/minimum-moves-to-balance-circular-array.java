class Solution {
    public long minMoves(int[] balance) {
        long sum = 0;
        boolean neg = false;
        int ind = 0;
        int n = balance.length;
        long ans = 0;

        for(int i=0;i<n;i++ ){
            int x = balance[i];
            sum += x;
            if(x < 0){
                neg = true;
                ind = i;
            }
        }

        if(sum < 0) return -1;
        if(!neg) return 0;
        int pivot = balance[ind];

        int st = 1;
        while(st <= n / 2 && pivot < 0){
            int l = (ind - st + n) % n;
            int r = (ind + st) % n;

            long tsum = balance[l] + balance[r];
            pivot += tsum;
            if(pivot >= 0){
                tsum -= pivot;
            }
            ans += st * tsum;
            
            st++;
        }
        return ans;
    }
}