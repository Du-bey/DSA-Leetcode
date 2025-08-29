class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : arr){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : h.keySet()){
            pq.add(h.get(x));
        }

        while(k > 0){
            int freq = pq.poll();
            k -= freq;
        }

        int ans = pq.size();
        return k == 0 ? ans : ans + 1;
    }
}