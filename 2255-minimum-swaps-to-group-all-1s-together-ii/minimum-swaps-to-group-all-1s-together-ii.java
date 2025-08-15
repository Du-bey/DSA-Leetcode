class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int N = n*2;
        int sum = 0;
        int[] num = new int[N];

        for(int i = 0;i<n;i++){
            sum += nums[i];
            num[i] = nums[i];
            num[i+n] = nums[i];
        }
        
        int l = 0;
        int ans = n;
        int temp = 0;

        for(int r =0;r < N;r++){
            temp += num[r];

            while(r - l + 1 > sum){
                temp -= num[l++];
            }

            int win = r - l + 1;
            
            if(win == sum){
                ans = Math.min(ans, win - temp);
            }
        }
        return ans;
    }
}