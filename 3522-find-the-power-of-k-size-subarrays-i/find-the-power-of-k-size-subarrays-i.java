class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) return nums;
        int n = nums.length;
        int[] res = new int[n-k+1];
        Arrays.fill(res,-1);
        int count = 1;
        for(int i=0; i<n-1; i++){
            if(nums[i+1] == nums[i]+1){
                count++;
            }else{
                count = 1;
            }

            if (count >= k){
                res[i-k+2] = nums[i+1];
            }
        }

        return res;
    }
}