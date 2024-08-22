class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for(int i =1;i<n;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        min = Math.abs(min);
        max = Math.abs(max);
        int flen = max + min + 1;
        int[] freq = new int[flen];
        for(int i = 0;i<n;i++){
            freq[nums[i] + min]++;
        }
        for(int i=1;i<flen;i++){
            freq[i] += freq[i-1];
        }
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            int x = nums[i];
            int pos = freq[nums[i] + min] - 1;
            freq[nums[i] + min]--;
            ans[pos] = nums[i];
        }
        return ans;
    }
}