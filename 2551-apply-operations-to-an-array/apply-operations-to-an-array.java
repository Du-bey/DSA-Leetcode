class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int ind = 0;
        for(int i =0;i<n;i++){
            if(nums[i] != 0){
                swap(i, ind, nums);
                ind++;
            }
        }
        return nums;
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}