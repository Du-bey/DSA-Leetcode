class Solution {
    public long minimumTime(int[] time, int t) {
        long l = 1;
        long min = Long.MAX_VALUE;
        for(int x : time){
            min = Math.min(min, x);
        }
        long h = min * t;
        long ans = 0;
        while(l <= h){
            long mid = l + (h-l)/2;
            if(isPossible(mid, time, t)){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(long mid, int[] time, int t){
        int trips = 0;
        for(int x : time){
            trips += (mid/x);
            if(trips >= t) return true;
        }
        return false;
    }
}