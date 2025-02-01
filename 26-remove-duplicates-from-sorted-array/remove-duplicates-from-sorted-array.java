class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ind = 0;
        for(int i =0;i<n;i++){
            nums[ind++] = nums[i];
            while(i < n - 1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return ind;
    }
}