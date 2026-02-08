class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = 1000000007;
        int[] events = new int[n];

        for(int[] r : requests){
            int st = r[0];
            int end = r[1];
            events[st]++;
            if(end + 1 < n){
                events[r[1] + 1]--;
            }
        }

        for(int i =1;i<n;i++){
            events[i] += events[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(events);

        long ans = 0;
        for(int i =0;i<n;i++){
            long extra = (long) events[i] * nums[i];
            extra %= mod;
            ans += extra;
            ans %= mod;
        }
        return (int) ans;
    }
}