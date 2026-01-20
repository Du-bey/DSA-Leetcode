class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i =0;i<n;i++){
            for(int a = 0; a <= 1000; a++){
                if((a | (a+1)) == nums.get(i)){
                    ans[i] = a;
                    break;
                }
            }
        }
        return ans;
    }
}