class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extra = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int [] r : connections){
            if(!ds.unionBySize(r[0], r[1])){
                extra++;
            }
        }
        int island = 0;
        for(int i =0;i<n;i++){
            if(ds.parent.get(i) == i) island++;
        }
        if(island - 1 > extra) return -1;
        return island - 1;
    }
}

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i =0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        var pNode = parent.get(node);
        if(node == pNode){
            return node;
        }
        int ulp = findUPar(pNode);
        parent.set(node, ulp);
        return ulp;
    }

    public void unionByRank(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return;
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
    }

    public boolean unionBySize(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return false;
        int ru = size.get(u);
        int rv = size.get(v);
        if(rv > ru){
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