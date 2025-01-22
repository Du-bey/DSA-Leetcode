class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : arr){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for(int i : h.keySet()){
            pq.add(new Pair(h.get(i) , i));
        }
        while(!pq.isEmpty() && k > 0){
            Pair p = pq.poll();
            int freq = p.freq;
            if(freq > k){
                freq -= k;
                pq.add(new Pair(freq, p.b));
                break;
            }
            else{
                k -= freq;
            }
        }
        return pq.size();
    }
}

class Pair{
    int freq;
    int b;
    public Pair(int freq, int b){
        this.freq = freq;
        this.b = b;
    }
}