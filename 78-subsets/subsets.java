class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int pow = (1 << n);
        for(int num =0; num < pow; num++){
            List<Integer> l = new ArrayList<>();
            for(int i =0;i<n;i++){
                int a = num & (1 << i);
                if(a != 0) l.add(nums[i]);
            }
            ans.add(new ArrayList<>(l));
        }
        return ans;
    }
}