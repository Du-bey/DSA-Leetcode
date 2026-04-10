class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            int a = nums[i];
            for(int j = i+1;j<n;j++){
                int b = nums[j];
                for(int k =j+1;k<n;k++){
                    int c = nums[k];
                    if(a == b && b == c){
                        int dis = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        ans = Math.min(ans, dis);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}