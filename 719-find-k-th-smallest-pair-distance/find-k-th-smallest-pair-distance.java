class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int min = 100000000;
        for(int x : nums){
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        int[] cnt = new int[max-min+1];
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int dif = Math.abs(nums[i] - nums[j]);
                cnt[dif]++;
            }
        }

        for(int i = 0;i<cnt.length;i++){
            k -= cnt[i];
            if(k <= 0) return i;
        }
        return -1;
    }
}