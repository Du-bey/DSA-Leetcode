class Solution {
    public List<List<Integer>> combinationSum(int[] can, int t) {
        int n = can.length;
        List<List<Integer>> ans = new ArrayList<>();
        f(0, t, can, ans, new ArrayList<>());
        return ans;
    }

    public void f(int i, int t, int[] can, List<List<Integer>> ans, List<Integer> l){
        if(i == can.length){
            if(t == 0){
                ans.add(new ArrayList < > (l));
            }
            return;
        }
        if(can[i] <= t){
            l.add(can[i]);
            f(i, t - can[i], can, ans, l);
            l.remove(l.size() - 1);
        }
        f(i+1, t, can, ans, l);

    }
}