class Solution {
    int[] parent = new int[26];
    int[] rank = new int[26];

    public int findUPar(int node){
        int par = parent[node];
        if(par == node){
            return node;
        }
        int leader = findUPar(par);
        parent[node] = leader;
        return leader;
    }

    public void union(int u,int v){
        int up = findUPar(u);
        int vp = findUPar(v);
        if(up == vp) return;
        int ru = rank[up];
        int rv = rank[vp];
        if(rv > ru){
            parent[up] = vp;
        }
        else if(ru > rv){
            parent[vp] = up;
        }
        else{
            parent[vp] = up;
            rank[up] = rank[up] +1;
        }
    }

    public boolean equationsPossible(String[] equations) {
        for(int i =0;i<26;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(String s : equations){
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';
            if(s.charAt(1) == '='){
                union(u, v);
            }
        }

        for(String s : equations){
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';
            if(s.charAt(1) == '!'){
                if(findUPar(u) == findUPar(v)){
                    return false;
                }
            }
        }
        return true;
    }
}