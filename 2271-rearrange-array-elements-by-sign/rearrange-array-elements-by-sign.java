class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] pos = new int[len/2];
        int[] neg = new int[len/2];
        int p = 0;
        int n = 0;
        for(int x : nums){
            if(x < 0) neg[n++] = x;
            else pos[p++] = x;
        }
        p = 0;
        n = 0;
        boolean ispos = true;
        for(int i =0;i<len;i++){
            if(ispos){
                nums[i] = pos[p++];
            }
            else{
                nums[i] = neg[n++];
            }
            ispos = !ispos;
        }
        return nums;
    }
}