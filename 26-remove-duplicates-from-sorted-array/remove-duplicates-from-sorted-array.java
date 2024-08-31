class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        nums[cnt] = nums[0];
        cnt++;
        for(int i =1;i<n;i++){
            if(nums[i] != nums[i-1]){
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}