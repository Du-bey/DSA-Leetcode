class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n+1);
        for(int[] edge : edges){
            if(ds.unionBySize(edge[0], edge[1]) == false){
                return edge;
            }
        }
        return new int[1];
    }
}

class DisjointSet{
    List<Integer> par;
    List<Integer> size;

    public DisjointSet(int u){
        par = new ArrayList<>();
        size = new ArrayList<>();
        for(int i =0;i<u;i++){
            par.add(i);
            size.add(1);
        }
    }

    public boolean unionBySize(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);
        if(up == vp) return false;
        int su = size.get(u);
        int sv = size.get(v);
        if(su > sv){
            size.set(up, su + sv);
            par.set(vp, up);
        }
        else{
            size.set(vp, su + sv);
            par.set(up, vp);
        }
        return true;
    }

    public int findUPar(int u){
        int p = par.get(u);
        if(p == u) return u;
        int up = findUPar(p);
        par.set(u, up);
        return up;
    }
}