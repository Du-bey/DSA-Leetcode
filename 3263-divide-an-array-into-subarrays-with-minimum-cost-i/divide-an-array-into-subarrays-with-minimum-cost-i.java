class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];
        int c = Math.max(nums[2], first);

        return a + b + c;
    }
}