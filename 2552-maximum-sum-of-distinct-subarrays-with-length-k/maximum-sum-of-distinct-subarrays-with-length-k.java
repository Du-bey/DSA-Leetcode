class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int i = 0;
        HashSet<Integer> h = new HashSet<>();
        long sum = 0;

        for(int j =0;j<n;j++){
            int x = nums[j];
            sum += x;
            while(h.contains(x) || h.size() > k - 1){
                int y = nums[i];
                sum -= y;
                h.remove(y);
                i++;
            }
            h.add(x);
            if(h.size() == k) ans = Math.max(ans, sum);
        }
        return ans;
    }
}