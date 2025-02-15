class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Double.compare(a.d, b.d));
        pq.add(new Triplet((double) arr[0] / arr[n-1], 0, n-1));
        boolean[][] vis = new boolean[n][n];
        vis[0][n-1] = true;
        while(--k > 0){
            Triplet p = pq.poll();
            int i = p.x;
            int j = p.y;
            if(i+1 < j && i+1 < n && !vis[i+1][j]){
                double frac = (double) arr[i+1] / arr[j];
                pq.add(new Triplet(frac, i+1, j));
                vis[i+1][j] = true;
            }

            if(j - 1 > i && !vis[i][j-1]){
                double frac = (double) arr[i] / arr[j-1];
                pq.add(new Triplet(frac, i, j-1));
                vis[i][j-1] = true;
            }
        }
        Triplet t = pq.poll();
        int[] ans = new int[2];
        ans[0] = arr[t.x];
        ans[1] = arr[t.y];
        return ans;
    }
}

class Triplet {  
    double d;  
    int x, y;  

    public Triplet(double d, int x, int y) {  
        this.d = d;  
        this.x = x;  
        this.y = y;  
    }  
}