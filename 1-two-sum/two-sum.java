class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            int num = nums[i];
            int num2 = target - num;
            if(h.containsKey(num2)){
                ans[0] = i;
                ans[1] = h.get(num2);
                return ans;
            }
            else{
                h.put(num, i);
            }
        }
        return ans;
    }
}