class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for(int i = 0;i + 2*k <=n;i++){
            boolean a = check(i, i+k, nums);
            boolean b = check(i+k, i+2*k, nums);
            if(a && b) return true;
        }
        return false;
    }

    public boolean check(int i, int j, List<Integer> nums){

        for(int ind = i + 1 ; ind < j ; ind++){
            if(nums.get(ind) <= nums.get(ind - 1)) return false;
        }
        return true;
    }
}
