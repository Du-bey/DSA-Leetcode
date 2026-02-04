class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<List<Integer>> adj = new ArrayList<>();
        TreeMap<Integer, List<Integer>> h = new TreeMap<>();
        DisjointSet ds = new DisjointSet(n);

        boolean[] active = new boolean[n];

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
            int val = vals[i];
            h.putIfAbsent(val, new ArrayList<>());
            h.get(val).add(i);
        }

        for(int[] r : edges){
            int a = r[0];
            int b = r[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int ans = n;
        for(int k : h.keySet()){
            List<Integer> l = h.get(k);
            for(int u : l){
                active[u] = true;
                for(int v : adj.get(u)){
                    if(active[v]){
                        ds.unionBySize(u, v);
                    }
                }
            }
            HashMap<Integer, Integer> pmap = new HashMap<>();

            for(int u : l){
                int par = ds.findUPar(u);
                pmap.put(par, pmap.getOrDefault(par, 0) + 1);
            }

            for(int k1 : pmap.keySet()){
                int val = pmap.get(k1);
                int res = val * (val - 1);
                res /= 2;
                ans += res; 
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