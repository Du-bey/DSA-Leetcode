class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> h = new HashMap<>();
        for(int[] row : matrix){
            StringBuilder val = new StringBuilder();
            StringBuilder rev = new StringBuilder();
            for(int r : row){
                val.append(r);
                rev.append(1-r);
            }

            String vs = val.toString();
            String rs = rev.toString();
            h.put(vs, h.getOrDefault(vs, 0) + 1);
            h.put(rs, h.getOrDefault(rs, 0) + 1);
        }
        int ans = -1;
        for(int v : h.values()){
            ans = Math.max(ans, v);
        }
        return ans;
    }
}