class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Double.compare(b.d, a.d));
        for(int i =0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                double frac = (double) arr[i] / arr[j];
                pq.add(new Triplet(frac, arr[i], arr[j]));
                if(pq.size() > k) pq.poll();
            }
        }
        Triplet t = pq.poll();
        int[] ans = new int[2];
        ans[0] = t.x;
        ans[1] = t.y;
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