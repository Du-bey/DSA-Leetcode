class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pm = new int[n];
        int[] sm = new int[n];
        pm[0] = height[0];
        sm[n-1] = height[n-1];
        for(int i =1;i<n;i++){
            pm[i] = Math.max(height[i], pm[i-1]);
        }
        for(int i =n-2;i>=0;i--){
            sm[i] = Math.max(height[i], sm[i+1]);
        }
        int ans = 0;
        for(int i =1;i<n-1;i++){
            if(pm[i] > height[i] && sm[i] > height[i]){
                ans+= Math.min(pm[i], sm[i]) - height[i];
            }
        }
        return ans;
    }
}