class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet ds1 = new DisjointSet(n+1);
        DisjointSet ds2 = new DisjointSet(n+1);

        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));

        int ans = 0;

        for(int[] r : edges){
            int u = r[2];
            int v = r[1];
            int z = r[0];
            if(z == 3){
                boolean a = ds1.unionBySize(u, v);
                boolean b = ds2.unionBySize(u, v);
                if(a == false && b == false) ans++;
            }

            else if(z == 2){
                boolean b = ds2.unionBySize(u, v);
                if(!b) ans++;
            }
            else{
                boolean a = ds1.unionBySize(u, v);
                if(!a) ans++;
            }
        }

        int apar = ds1.findUPar(1);
        int bpar = ds2.findUPar(1);

        for(int i =2;i<=n;i++){
            if(ds1.findUPar(i) != apar) return -1;
            if(ds2.findUPar(i) != bpar) return -1;
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