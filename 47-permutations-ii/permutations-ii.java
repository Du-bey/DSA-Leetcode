class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : nums){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        solve(nums, ans, temp, h);
        return ans;
    }

    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> temp, HashMap<Integer, Integer> h){
        int n = nums.length;
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int x : h.keySet()){
            if(h.get(x) > 0){
                h.put(x, h.get(x) - 1);
                temp.add(x);
                solve(nums, ans, temp, h);
                h.put(x, h.get(x) + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}