class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int ans = 0;

        HashMap<Integer, Integer> h = new HashMap<>();
        for(int j =0;j<n;j++){
            int x = nums[j];
            h.put(x, h.getOrDefault(x, 0) + 1);
            while(h.get(x) > k){
                h.put(nums[i], h.get(nums[i]) - 1);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}