class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[n-1];
        for(int i =0;i<n-2;i++){
            int j = i+1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return sum;
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                if(Math.abs(ans - target) > Math.abs(sum - target)){
                    ans = sum;
                }
            }
        }
        return ans;
    }
}