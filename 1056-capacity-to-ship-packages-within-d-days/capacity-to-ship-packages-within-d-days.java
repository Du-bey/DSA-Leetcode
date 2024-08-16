class Solution {
    public int shipWithinDays(int[] w, int days) {
        int n = w.length;
        int l = 0;
        int h =0;
        for(int x : w){
            h+= x;
            l = Math.max(l, x);
        }
        int ans = 0;
        while(l <= h){
            int m = (l+h)/2;
            if(check(m, w, days)){
                h = m - 1;
                ans = m;
            }
            else{
                l = m + 1;
            }
        }
        return l;
    }

    public boolean check(int m, int[] w, int days){
        int d = 1;
        int wt = 0;
        for(int x : w){
            wt += x;
            if(wt > m){
                wt = x;
                d++;
            }
        }
        return d <= days;
    }
}