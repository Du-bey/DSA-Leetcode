class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        for(int i =0;i<n;i++){
            int a = nums[i];
            int z = 0;
            while(z<a && i+z < n){
                t[i+z]++;
                z++;
            }
        }
        for(int i =0;i<n-1;i++){
            if(t[i] == 0){
                return false;
            }
        }
        return true;
    }
}