class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int i =0;i<n;i++){
            sum+= nums[i];
            if(h.containsKey(sum - k)){
                ans+= h.get(sum -k);
            }
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}