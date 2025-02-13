class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums2[i], nums1[i]);
        }

        Arrays.sort(pairs, (a, b) -> b.a - a.a);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long ans = 0;
        long sum = 0;
        for(int i =0;i<n;i++){
            Pair p = pairs[i];
            pq.add(p.b);
            sum += p.b;
            if(pq.size() > k){
                sum -= pq.poll();
            }

            if(pq.size() == k){
                ans = Math.max(ans, sum * p.a);
            }
        }
        return ans;
    }
}

class Pair {  
    int a, b;  

    public Pair(int a, int b) {  
        this.a = a;  
        this.b = b;  
    }  
}