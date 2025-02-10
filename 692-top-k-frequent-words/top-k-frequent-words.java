class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
        a.freq == b.freq ? b.s.compareTo(a.s) : a.freq - b.freq);
        HashMap<String, Integer> h = new HashMap<>();
        for(String s : words){
            h.put(s, h.getOrDefault(s, 0) + 1);
        }
        for(String s : h.keySet()){
            pq.add(new Pair(s, h.get(s)));
            if(pq.size() > k) pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(k -- > 0){
            Pair p = pq.poll();
            ans.add(p.s);
        }
        Collections.reverse(ans);
        return ans;
    }
}
class Pair{
    String s;
    int freq;
    public Pair(String s, int freq){
        this.s = s;
        this.freq = freq;
    }
}