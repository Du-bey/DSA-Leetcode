class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int x : nums){
            freq[x]++;
        }
        int ind = 0;
        for(int i = 0;i<freq[0];i++){
            nums[ind++] = 0;
        }
        for(int i =0; i< freq[1];i++){
            nums[ind++] = 1;
        }
        for(int i =0; i< freq[2];i++){
            nums[ind++] = 2;
        }
    }
}