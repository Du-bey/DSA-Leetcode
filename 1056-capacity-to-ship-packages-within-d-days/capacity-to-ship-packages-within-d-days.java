class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int l = 0;
        int h = 0;
        for(int x : arr){
            l = Math.max(l, x);
            h += x;
        }

        int ans = 0;
        while(l <= h){
            int m = (l+h) / 2;
            if(isPossible(m, arr, days)){
                h = m - 1;
                ans = m;
            }
            else {
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int m, int[] arr, int days){
        int d = 0;
        int cap = 0;
        for(int x : arr){
            cap += x;
            if(cap > m){
                cap = x;
                d++;
            }
        }
        if(cap > 0) d++;
        return d <= days;
    }
}