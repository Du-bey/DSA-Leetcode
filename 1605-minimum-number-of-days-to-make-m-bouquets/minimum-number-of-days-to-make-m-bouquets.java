class Solution {
    public int minDays(int[] bloomDay, int b, int k) {
        
        int n = bloomDay.length;
        if(n < b*k) return -1;

        int l = Integer.MAX_VALUE;
        int h = 0;
        for(int x : bloomDay){
            h = Math.max(h, x);
            l = Math.min(l, x);
        }
        int ans = -1;

        while(l <= h){
            int m = l + (h-l)/2;
            if(isPossible(m, bloomDay, b, k)){
                h = m - 1;
                ans = m;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int m, int[] bloomDay, int b, int k){
        int cnt = 0;
        int bouquet = 0;
        
        for(int x : bloomDay){
            if(m >= x){
                cnt++;
            }
            else{
                cnt = 0;
            }
            if(cnt == k){
                bouquet++;
                cnt = 0;
            }
            if(bouquet >= b) return true;
        }
        return false;
    }
}