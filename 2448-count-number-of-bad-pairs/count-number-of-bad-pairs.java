class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            int val = nums[i] - i;
            ans += i;
            if(h.containsKey(val)){
                ans -= h.get(val);
            }
            h.put(val, h.getOrDefault(val, 0) + 1);
        }
        return ans;
    }
}