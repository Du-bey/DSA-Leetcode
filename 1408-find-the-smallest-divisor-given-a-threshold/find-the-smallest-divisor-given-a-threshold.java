class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int l = 1;
        int h = 0;
        for(int x : nums){
            h = Math.max(h, x);
        }
        int ans = 0;
        while(l <= h){
            int m = (l+h)/2;
            if(isPossible(m, nums, t)){
                h = m - 1;
                ans = m;
            }
            else l = m + 1;
        }
        return ans;
    }

    public boolean isPossible(int m, int[] nums, int t) {
        int ans = 0;
        for(int x : nums){
            int rem = x % m;
            int div = x / m;
            if(rem > 0) div++;
            ans += div;
        }
        return ans <= t;
    }
}