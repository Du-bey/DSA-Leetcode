class Solution {
    public int makeConnected(int n, int[][] c) {
        DisjointSet1 ds = new DisjointSet1(n);
        int extra = 0;
        for(int[] r: c){
            int u = r[0];
            int v = r[1];
            if(!ds.unionBySize(u, v)) extra++;
        }
        int reqd = 0;
        for(int i =0;i<n;i++){
            if(ds.findUPar(i) == i) reqd++;
        }
        reqd--;
        return (extra >= reqd) ? reqd : -1;
    }
}

public class DisjointSet1 {
    int[] par;
    int[] rank;
    int[] size;

    public DisjointSet1(int n){
        par =  new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i= 0;i<n;i++){
            par[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findUPar(int u){
        int p = par[u];
        if(p == u) return u;
        par[u] = findUPar(p);
        return par[u];
    }

    public boolean unionBySize(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);
        if(upar == vpar) return false;
        if(size[vpar] > size[upar]){
            par[upar] = vpar;
            size[vpar] += size[upar];
        }
        else{
            par[vpar] = upar;
            size[upar] += size[vpar];
        }
        return true;
    }

    public boolean unionByRank(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);
        if(upar == vpar) return false;
        if(rank[vpar] > rank[upar]){
            par[upar] = vpar;
        }
        else if(rank[vpar] < rank[upar]){
            par[vpar] = upar;
        }
        else{
            par[vpar] = upar;
            rank[upar]++;
        }
        return true;
    }
}