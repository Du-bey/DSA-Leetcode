class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int ind = 0;ind <n;ind++){
            h.put(nums[ind], ind);
        }
        int ans = 1;

        int i = 0;
        int j = Math.max(0, h.get(nums[0]));
        while(i < n){
            if(i > j) ans *= 2;
            ans %= mod;
            j = Math.max(j, h.get(nums[i]));
            i++;
        }
        return ans;
    }

}