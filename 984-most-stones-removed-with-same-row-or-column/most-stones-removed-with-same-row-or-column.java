class Solution {
    public int removeStones(int[][] st) {
        int n = 0;
        int m = 0;

        for(int[] s : st){
            n = Math.max(n, s[0]);
            m = Math.max(m, s[1]);
        }

        DisjointSet ds = new DisjointSet(n+m+1);
        for(int[] stone : st){
            int r = stone[0];
            int c = stone[1];
            ds.unionBySize(r, n+1+c);
        }
        int cnt = 0;
        int no = n+m+2;
        for(int i =0;i<no;i++){
            if(ds.parent.get(i) == i && ds.size.get(i) > 1){
                cnt++;
            }
        }
        return st.length - cnt;
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

    public void unionBySize(int u, int v){
        int up = findUPar(u);
        int vp = findUPar(v);

        if(up == vp) return;
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
    }

}