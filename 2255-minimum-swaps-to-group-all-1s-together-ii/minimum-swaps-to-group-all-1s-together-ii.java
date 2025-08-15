class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        
        int l = 0;
        int ans = n;
        int temp = 0;

        for(int r =0;r < 2 * n;r++){
            temp += nums[r % n];

            while(r - l + 1 > sum){
                temp -= nums[l % n];
                l++;
            }

            int win = r - l + 1;
            
            if(win == sum){
                ans = Math.min(ans, win - temp);
            }
        }
        return ans;
    }
}