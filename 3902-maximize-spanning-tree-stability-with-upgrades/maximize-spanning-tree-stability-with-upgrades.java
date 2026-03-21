class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DisjointSet ds = new DisjointSet(n);

        for(int[] r : edges){
            int u = r[0];
            int v = r[1];

            int s = r[2];
            int m = r[3];

            if(m == 1){
                if(ds.findUPar(u) == ds.findUPar(v)) return -1;
                ds.unionBySize(u, v);
            }
        }

        int l = 1;
        int h = 200000;

        int ans = -1;

        while(l <= h){
            int m = (l + h) / 2;
            if(check(n, edges, k, m)){
                ans = m;
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return ans;
    }

    public boolean check(int n, int[][] edges, int k, int mid){
        DisjointSet ds = new DisjointSet(n);
        List<Pair> upg = new ArrayList<>();

        for(int[] r : edges){
            int u = r[0];
            int v = r[1];

            int s = r[2];
            int m = r[3];

            if(m == 1){
                if(s < mid) return false;
                ds.unionBySize(u, v);
            }
            else{
                if(s >= mid){
                    ds.unionBySize(u, v);
                }
                else if(2 * s >= mid){
                    Pair p = new Pair(u, v);
                    upg.add(p);
                }
            }
        }

        for(Pair p : upg){
            int u = p.u;
            int v = p.v;
            if(ds.findUPar(u) != ds.findUPar(v)){
                if(k <= 0) return false;
                ds.unionBySize(u, v);
                k--;
            }
        }

        int proot = ds.findUPar(0);
        for(int i =1;i<n;i++){
            if(ds.findUPar(i) != proot) return false;
        }
        return true;
    }
    
}

class DisjointSet{
    int[] par;
    int[] size;

    public DisjointSet(int n){
        par = new int[n];
        size = new int[n];

        for(int i =0;i<n;i++){
            par[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int u){
        if(par[u] == u) return u;

        int p = findUPar(par[u]);
        par[u] = p;
        return p;
    }

    public boolean unionBySize(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);
        if(upar == vpar) return false;

        int ru = size[upar];
        int rv = size[vpar];

        if(ru > rv){
            par[vpar] = upar;
            size[upar] += size[vpar];
        }
        else{
            par[upar] = vpar;
            size[vpar] += size[upar];
        }
        return true;
    }
}

class Pair{
    int u;
    int v;
    public Pair(int u, int v){
        this.u = u;
        this.v = v;
    }
}