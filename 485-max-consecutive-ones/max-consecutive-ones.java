class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int range = 0;
        for (int num : nums) {
            range = num == 1 ? range + 1 : 0;
            ans = Math.max(range, ans);
        }
        return ans;
    }
}