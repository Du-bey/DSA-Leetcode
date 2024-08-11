class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> h = new HashSet<>();
        for(int i : nums){
            if(h.contains(i)) return true;
            h.add(i);
        }
        return false;
    }
}