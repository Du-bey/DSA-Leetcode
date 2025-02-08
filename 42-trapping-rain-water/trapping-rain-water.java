class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] premax = new int[n];
        premax[0] = height[0];
        for(int i =1;i<n;i++){
            premax[i] = Math.max(premax[i-1], height[i]);
        }

        int[] sufmax = new int[n];
        sufmax[n-1] = height[n-1];
        for(int i =n-2;i>=0;i--){
            sufmax[i] = Math.max(sufmax[i+1], height[i]);
        }
        int ans = 0;
        for(int i =0;i<n;i++){
            int min = Math.min(premax[i], sufmax[i]);
            if(min - height[i]> 0) ans += min - height[i];
        }
        return ans;
    }
}