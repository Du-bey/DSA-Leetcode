class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int ind = 0;
        for(int i =0;i<n;i++){
            if(nums[i] != 0){
                swap(i, ind, nums);
                ind++;
            }
        }
        
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}