class Solution {
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        int n = c.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(c);
        f(0, t, c, ans, new ArrayList<>());
        return ans;
    }

    public void f(int i, int t, int[] c, List<List<Integer>> ans, List<Integer>ds){
        if(t == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
    
        for(int ind = i; ind < c.length;ind++){
            if(ind > i && c[ind] == c[ind-1]) continue;
            if(c[ind] > t) break;
            ds.add(c[ind]);
            f(ind + 1, t - c[ind], c, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}