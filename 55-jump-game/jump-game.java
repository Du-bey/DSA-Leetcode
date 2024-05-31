class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        for(int i =0;i<n-1;i++){
            int a = nums[i];
            maxi = Math.max(maxi, i+a);
            int z = i + a;
            System.out.println(maxi + " " + n);
            if(maxi >= n-1) return true;
            if(maxi == i) return false;
        }
        if(maxi >= n-1) return true;
        
        return false;
    }
}