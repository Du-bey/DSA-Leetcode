class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            if(h.containsKey(nums[i])){
                int j = h.get(nums[i]);
                if(Math.abs(i-j) <= k) return true;
            }
            h.put(nums[i], i);
        }
        return false;
    }
}