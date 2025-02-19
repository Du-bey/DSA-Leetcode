class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, n, k, ans, new ArrayList<>());
        return ans;
    }
    public void solve(int i, int n, int k, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int ind =i;ind<=n;ind++){
            temp.add(ind);
            solve(ind+1, n, k, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}