class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        for(int[] r : connections){
            int a = r[0];
            int b = r[1];
            if(!ds.unionBySize(a, b)) extra++;
        }
        int reqd = 0;
        for(int i =0;i<n;i++){
            if(ds.findUPar(i) == i){
                reqd++;
            }
        }
        reqd--;
        return (extra >= reqd) ? reqd : -1;
    }
}

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0;i<=n;i++){
            size.add(1);
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        int par = parent.get(node);
        if(par == node) return node;
        int upar = findUPar(par);
        parent.set(node, upar);
        return upar;
    }

    public boolean unionByRank(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return false;
        int ru = rank.get(u);
        int rv = rank.get(v);
        if(rv > ru){
            parent.set(up, vp);
        }
        else if(ru > rv){
            parent.set(vp, up);
        }
        else{
            parent.set(vp, up);
            int upRank = rank.get(up);
            upRank++;
            rank.set(up, upRank);
        }
        return true;
    }

    public boolean unionBySize(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);
        if(up == vp) return false;
        int su = size.get(u);
        int sv = size.get(v);
        if(sv > su){
            parent.set(up, vp);
            size.set(vp, size.get(up) + size.get(vp));
        }
        else{
            parent.set(vp, up);
            size.set(up, size.get(up) + size.get(vp));
        }
        return true;
    }
}
