class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Double.compare(b.third , a.third));
        for(int[] r : points){
            int x = r[0];
            int y = r[1];
            double d = Math.sqrt((x*x) + (y*y));
            pq.add(new Triplet(x, y, d));
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int ind = 0;
        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            int x = t.first;
            int y = t.second;
            ans[ind][0] = x;
            ans[ind][1] = y;
            ind++;
        }
        return ans;
    }
}

class Triplet {
    int first;
    int second;
    double third;

    public Triplet(int first, int second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}