class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        long l = 1;
        long min = Long.MAX_VALUE;
        for(int x : time){
            min = Math.min(min, x);
        }
        long h = (totalTrips * min);

        long ans = 0;
        while(l <= h){
            long m= l + (h - l)/2;
            if(isPossible(m, time, totalTrips)){
                ans = m;
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(long m, int[] time, int t){
        long trips = 0;
        for(int x : time){
            trips += m / x;
            if(trips >= t) return true;
        }
        return false;
    }
}