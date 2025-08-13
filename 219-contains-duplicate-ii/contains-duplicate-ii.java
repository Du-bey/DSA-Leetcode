class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        int j = 0;
        for(int i =0;i<n;i++){
            if(i - j > k){
                set.remove(nums[j++]);
            }
            if(set.contains(nums[i])){
                return true;
            }
            set.add
            (nums[i]);
        }
        return false;
    }
}