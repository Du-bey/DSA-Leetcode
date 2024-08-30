class Solution {
    public int[][] merge(int[][] in) {
        int n = in.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(in, (a, b) -> a[0] - b[0]);
        for(int i =0;i<n;i++){
            if(i < n-1 && in[i][1] >= in[i+1][0]){
                in[i+1][0] = in[i][0];
                if(in[i][1] >= in[i+1][1]){
                    in[i+1][1] = in[i][1];
                }
            }
            else{
                ans.add(in[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}