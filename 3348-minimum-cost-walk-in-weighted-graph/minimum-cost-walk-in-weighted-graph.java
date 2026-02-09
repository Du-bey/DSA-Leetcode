class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        int[] val = new int[n];
        Arrays.fill(val, -1);

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            int w = e[2];
            int pa = ds.findUPar(a);
            int pb = ds.findUPar(b);

            if(pa != pb){
                ds.unionBySize(a, b);
                int upar = ds.findUPar(pa);
                int v = w;

                if(val[pa] != -1) v &= val[pa];
                if(val[pb] != -1) v &= val[pb];
                val[upar] = v;
            }
            else{
                val[pa] &= w;
            }
        }

        int qn = query.length;
        int[] ans = new int[qn];
        int ind = 0;

        for(int[] e : query){
            int a = e[0];
            int b = e[1];
            if(ds.findUPar(a) != ds.findUPar(b)){
                ans[ind++] = -1;
            }
            else{
                int p = ds.findUPar(a);
                ans[ind++] = val[p];
            }
        }
        return ans;
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