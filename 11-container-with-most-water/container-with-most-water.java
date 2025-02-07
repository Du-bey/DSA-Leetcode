class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int h = n - 1;
        int ans = 0;
        while(l < h){
            ans = Math.max(ans, Math.min(height[l], height[h]) * (h - l));
            if(height[h] < height[l]) h--;
            else l++;
        }
        return ans;
    }
}