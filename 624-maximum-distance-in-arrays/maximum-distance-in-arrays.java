class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int arrSize = arrays.size();
        int ans = -1;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for(int i =1;i<arrSize;i++){
            List<Integer> a = arrays.get(i);
            int n = a.size();
            int w = Math.abs(a.get(0) - max);
            int x = Math.abs(a.get(n-1) - max);
            int y = Math.abs(a.get(0) - min);
            int z = Math.abs(a.get(n-1) - min);
            w = Math.max(w,x);
            y = Math.max(y,z);
            w = Math.max(w, y);
            ans = Math.max(ans, w);
            max = Math.max(max, a.get(n-1));
            min = Math.min(min, a.get(0));
        }
        return ans;
    }
}