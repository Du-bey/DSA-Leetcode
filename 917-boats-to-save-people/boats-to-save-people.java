class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int i = 0;
        int j = n-1;
        while(i <= j){
            if(nums[i] + nums[j] <= limit && i != j){
                ans++;
                i++;
                j--;
            }
            else if(nums[i] > nums[j]){
                if(nums[i] <= limit){
                    i++;
                    ans++;
                }
            }
            else{
                if(nums[j] <= limit){
                    ans++;
                    j--;
                }
            }
        }
        return ans;
    }
}