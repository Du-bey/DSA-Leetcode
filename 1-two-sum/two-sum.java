class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        int[] ans = new int[2];
        for(int i =0;i<n;i++){
            if(h.containsKey(target - nums[i])){
                ans[0] = h.get(target- nums[i]);
                ans[1] = i;
                return ans;
            }
            h.put(nums[i], i);
        }
        return ans;
    }
}