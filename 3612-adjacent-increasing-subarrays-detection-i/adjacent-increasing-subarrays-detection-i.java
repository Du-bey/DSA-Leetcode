class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        int crun = 1;
        int prun = 0;

        for(int i =1;i<n;i++){
            if(nums.get(i) > nums.get(i-1)){
                crun++;
            }
            else{
                prun = crun;
                crun = 1;
            }
            if(crun >= 2 *k) return true;
            if(Math.min(crun, prun) >= k) return true;
        }
        return false;
    }
}