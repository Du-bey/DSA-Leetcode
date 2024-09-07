class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        if(p == 0) return 0;
        int n = nums.length;
        int l = 0;
        int h = nums[n-1] - nums[0];
        while(l <= h){
            int m = (l+h)/2;
            if(help(nums, p, m)){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return l;
    }
    public boolean help(int[] nums, int p, int dif){
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if((nums[i+1] - nums[i]) <= dif){
                cnt++;
                i++;
            }
            if(cnt >= p){
                return true;
            }
        }
        return false;
    }
}