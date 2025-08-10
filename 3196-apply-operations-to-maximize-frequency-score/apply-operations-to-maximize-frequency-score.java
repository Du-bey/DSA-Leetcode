class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);

        long[] pre = new long[n];
        pre[0] = nums[0];
        for(int i =1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }

        int l = 1;
        int h = n;
        int ans = 1;

        while(l <= h){
            int m = (l+h)/2;
            if(possible(m, nums, pre, k, n)){
                ans = m;
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return ans;
    }

    private boolean possible(int len, int[] nums, long[] prefix, long k, int n) {
        if (len == 0)
            return false;

        int i = 0;
        int j = len - 1;

        while (j < n) {
            long targetIdx = (i + j) / 2;
            long target = nums[(int) targetIdx];

            long operationsLeft;
            long operationsRight;

            if (targetIdx == 0) {
                operationsLeft = 0;
            } else {
                operationsLeft = Math.abs(((targetIdx - i) * target)
                        - (prefix[(int) targetIdx - 1] - (i > 0 ? prefix[i - 1] : 0)));
            }

            operationsRight = Math.abs(((j - targetIdx) * target) - (prefix[j] - prefix[(int) targetIdx]));

            if (operationsRight + operationsLeft <= k) {
                return true;
            }

            i++;
            j++;
        }

        return false;
    }
}