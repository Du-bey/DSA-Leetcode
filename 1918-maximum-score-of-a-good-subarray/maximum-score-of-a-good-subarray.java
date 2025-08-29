class Solution {
    public int maximumScore(int[] nums, int k) {
        int j = k;
        int i = k;
        int min = nums[k];
        int ans = nums[k];
        int n = nums.length;

        while(i > 0 && j < n-1){
            if(nums[i-1] < nums[j+1]){
                j++;
                min = Math.min(min, nums[j]);
            }
            else{
                i--;
                min = Math.min(min, nums[i]);
            }
            ans = Math.max(ans, min * (j - i + 1));
        }

        while(i > 0){
            i--;
            min = Math.min(min, nums[i]);
            ans = Math.max(ans, min * (j - i + 1));
            
        }

        while(j <n-1){
            j++;
            min = Math.min(min, nums[j]);
            ans = Math.max(ans, min * (j - i + 1));
            
        }        
        return ans;
    }
}