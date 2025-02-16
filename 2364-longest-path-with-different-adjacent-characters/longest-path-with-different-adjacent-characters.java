class Solution {
    int ans = Integer.MIN_VALUE;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            if(parent[i] != -1){
                adj.get(parent[i]).add(i);
            }
        }
        f(0, -1, s, adj);
        return ans;
    }

    public int f(int u, int par, String s, List<List<Integer>> adj){
        char c = s.charAt(u);

        int retVal = 0;
        int l = 0;
        int sl = 0;
        for(int v : adj.get(u)){
            if(v != par){
                int child = f(v, u, s, adj);
                if(c == s.charAt(v)) continue;
                retVal = Math.max(retVal, child);
                if(child > l){
                    sl = l;
                    l = child;
                }
                else if(child > sl){
                    sl = child;
                }
            }
        }
        
        ans = Math.max(ans, 1 + sl + l);
        return 1 + l;
    }
}