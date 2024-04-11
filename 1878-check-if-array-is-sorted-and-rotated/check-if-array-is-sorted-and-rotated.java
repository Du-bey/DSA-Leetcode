class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i =1;i<=nums.length;i++){
            if(nums[i-1] > nums[i % n]){
                if(ans == 1) return false;
                ans++;
            }
        }
        return true;
    }
}
