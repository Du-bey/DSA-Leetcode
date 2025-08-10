class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int h = nums[n-1] - nums[0];

        int ans = 0;
        while(l <= h){
            int m = l + (h-l)/2;
            int cnt = count(m, nums);
            if(cnt < k){
                l = m + 1;
            }
            else{
                ans = m;
                h = m - 1;
            }
        }
        return ans;
    }

    public int count(int m, int[] nums){
        int n = nums.length;
        int i = 0;
        int j = 1;
        int cnt = 0;
        while(j < n){
            while(nums[j] - nums[i] > m){
                i++;
            }
            cnt += j - i;
            j++;
        }
        return cnt;
    }
}