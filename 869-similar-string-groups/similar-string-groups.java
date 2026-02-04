class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i =0;i<n-1;i++){
            int sn = strs[i].length();
            for(int j =i+1; j<n;j++){
                if(same(strs[i], strs[j], sn)){
                    ds.unionBySize(i ,j);
                }
            }
        }

        int cnt = 0;
        for(int i =0;i<n;i++){
            if(ds.findUPar(i) == i) cnt++;
        }
        return cnt;
    }

    public boolean same(String s, String t, int n){
        int first = -1;
        int second = -1;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            char ch = t.charAt(i);
            if(c != ch){
                if(second != -1) return false;
                if(first == -1) first = i;
                else second = i;
            }
        }
        return first == -1 || s.charAt(first) == t.charAt(second);
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

    public void unionBySize(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);
        if(upar == vpar) return;

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
    }
}