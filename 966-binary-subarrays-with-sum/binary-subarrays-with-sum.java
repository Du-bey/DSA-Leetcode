class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, 1);

        int ans = 0;
        int sum = 0;
        for(int x : nums){
            sum += x;
            int rem = sum - goal;
            if(h.containsKey(rem)){
                ans += h.get(rem);
            }
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}