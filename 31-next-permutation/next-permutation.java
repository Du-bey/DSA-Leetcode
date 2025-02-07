class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                ans = i;
                break;
            }
        }
        if(ans == -1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int i = n -1;i>ans;i--){
            if(nums[ans] < nums[i]){
                int temp = nums[ans];
                nums[ans] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, ans + 1, n - 1);
    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}