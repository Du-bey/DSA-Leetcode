class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        

        Map<Integer, List<Integer>> h = new HashMap<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int ind = i + j;
                h.putIfAbsent(ind, new ArrayList<>());
                h.get(ind).add(mat[i][j]);
            }
        }
        boolean flip = true;
        List<Integer> temp = new ArrayList<>();
        for(int k = 0; k < m+n-1;k++){
            List<Integer> d = h.get(k);
            if(d == null) continue;
            if(flip) Collections.reverse(d);
            temp.addAll(d);
            flip = !flip;
        }
        
        int tsize = temp.size();
        int[] ans = new int[tsize];
        for(int i =0;i<tsize;i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}