class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extra = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int[] r : connections){
            int a = r[0];
            int b = r[1];
            if(!ds.unionBySize(a, b)){
                extra++;
            }
        }

        int c = 0;
        for(int i =0;i<n;i++){
            if(ds.findUPar(i) == i) c++;
        }

        extra++;
        if(c > extra) return -1;
        return c - 1;
    }
}

class DisjointSet{
    int[] par;
    int[] rank;
    int[] size;

    public DisjointSet(int n){
        par = new int[n];
        rank = new int[n];
        size = new int[n];

        for(int i =0;i<n;i++){
            par[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findUPar(int u){
        if(par[u] == u) return u;

        int p = findUPar(par[u]);
        par[u] = p;
        return p;
    }

    public void unionByRank(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);
        if(upar == vpar) return;

        int ru = rank[upar];
        int rv = rank[vpar];

        if(ru > rv){
            par[vpar] = upar;
        }
        else if(ru < rv){
            par[upar] = vpar;
        }
        else{
            par[upar] = vpar;
            rank[vpar]++;
        }
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