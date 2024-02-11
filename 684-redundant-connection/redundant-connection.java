class Solution {
    int n;
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i =0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int[] ans = new int[2];
        for(int i =0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int up = findUPar(u);
            int vp = findUPar(v);
            if(!connect(up,vp)){
                ans[0] = u;
                ans[1] = v;
            }
        }
    return ans;
    }

    public int findUPar(int node) {
        int p = parent[node];
        if(node == p) return node;
        int uPar = findUPar(p);
        parent[node] = uPar;
        return uPar;
    }

    public boolean connect(int u, int v) {
        int up = parent[u];
        int vp = parent[v];
        if(up == vp) return false;
        int ru = rank[u];
        int rv = rank[v];
        if(ru > rv){
            parent[vp] = up;
            ru+=rv;
        }
        else if(ru < rv){
            parent[up] = vp;
        }
        else{
            parent[vp] = up;
            rank[up]++;
        }
        return true;
    }
}