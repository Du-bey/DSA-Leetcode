class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int i = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        long sum = 0;

        for(int j =0;j<n;j++){
            int x = nums[j];
            sum += x;
            while(h.containsKey(x) || h.size() > k - 1){
                int y = nums[i];
                sum -= y;
                h.put(y, h.get(y) - 1);
                if(h.get(y) == 0) h.remove(y);
                i++;
            }
            h.put(x, h.getOrDefault(x, 0) + 1);
            if(h.size() == k) ans = Math.max(ans, sum);
        }
        return ans;
    }
}