class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int n = nums.length;
        for(int i =0;i<n;i++){
            int com = target - nums[i];
            
            if(h.containsKey(com)){
                return new int[] {h.get(com), i};
            }
            h.put(nums[i], i);
        }
        return null;
    }  
}