class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] sufmax = new int[n];
        sufmax[n-1] = height[n-1];
        for(int i =n-2;i>=0;i--){
            sufmax[i] = Math.max(sufmax[i+1], height[i]);
        }
        int ans = 0;
        int premax = height[0];
        for(int i =0;i<n;i++){
            premax = Math.max(premax, height[i]);
            int min = Math.min(premax, sufmax[i]);
            if(min - height[i]> 0) ans += min - height[i];
        }
        return ans;
    }
}