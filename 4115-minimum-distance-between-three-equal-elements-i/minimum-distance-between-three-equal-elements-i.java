class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<n-2;i++){
            int a = nums[i];
            for(int j = i+1;j<n-1;j++){
                int b = nums[j];
                if(a != b) continue;
                for(int k =j+1;k<n;k++){
                    int c = nums[k];
                    if(b == c){
                        int dis = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        ans = Math.min(ans, dis);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}