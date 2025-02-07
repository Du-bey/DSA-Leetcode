class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, nums, t, new ArrayList<>(), ans);
        return ans;
    }

    public void f(int i, int[] nums, int t, List<Integer> temp, List<List<Integer>> ans){
        if(i == nums.length){
            if(t == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[i] <= t){
            temp.add(nums[i]);
            f(i, nums, t - nums[i], temp, ans);
            temp.remove(temp.size() - 1);
        }
        f(i+1, nums, t, temp, ans);
    }
}