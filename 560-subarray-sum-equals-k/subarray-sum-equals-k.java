class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, 1);

        int sum = 0;
        int ans = 0;
        for(int x : nums){
            sum += x;
            int rem = sum - k;
            if(h.containsKey(rem)){
                ans += h.get(rem);
            }
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}