class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int ans = 0;
        int i= 0;
        int j = 0;

        while(j < n){
            if(nums[j] > (long)nums[i] * k){
                i++;
                continue;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        
        return n - ans;
    }
}