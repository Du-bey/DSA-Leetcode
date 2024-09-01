class Solution {
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n ; col++) {
                if (grid[row][col] == 0) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        
        mx = Math.max(mx, ds.size.get(ds.findUPar(0)));
        return mx;
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