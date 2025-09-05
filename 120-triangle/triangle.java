class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[] next = new int[n];
        for(int i = 0;i<n;i++){
            next[i] = t.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            int[] cur = new int[n];
            for(int j = i; j>=0;j--){
                int d = next[j];
                int dr = next[j+1];
                cur[j] = t.get(i).get(j) + Math.min(d, dr);
            }
            next = cur;
        }
        return next[0];
    }
}