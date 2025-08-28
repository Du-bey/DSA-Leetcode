class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] pc = new Pair[n];
        for(int i =0;i<n;i++){
            pc[i] = new Pair(profits[i], capital[i]);
        }

        Arrays.sort(pc, (a, b) -> a.b - b.b);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ind = 0;
        while(k > 0){
            while(ind < n && w >= pc[ind].b){
                pq.add(pc[ind].a);
                ind++;
            }
            if(pq.isEmpty()) return w;
            w += pq.poll();
            k--;
        }
        return w;
    }
}

class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}