class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            nums[i] = nums[i] % 2;
        }
        return f(nums, k) - f(nums, k-1);
    }

    public static int f(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int l =0;
        int sum =0;
        int cnt = 0;
        for(int r =0;r<n;r++){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            cnt += (r-l+1);
        }
        return cnt;
    }
}