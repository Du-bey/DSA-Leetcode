class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i =0;i<n;i++){
            int x = nums.get(i);

            if(x < 3) continue;

            for(int bit = 0; bit <= 32; bit++){
                if((x & (1 << bit)) > 0) continue;

                int prev = bit - 1;
                ans[i] = x ^ (1 << prev);
                break;
            }
        }
        return ans;
    }
}