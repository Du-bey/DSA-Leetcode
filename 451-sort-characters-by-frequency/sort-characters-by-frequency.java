class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for(char c : s.toCharArray()){
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.b - x.b);
        for(Character c : h.keySet()){
            pq.add(new Pair(c, h.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            char c = p.a;
            int freq = p.b;
            for(int i =0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

class Pair{
    char a;
    int b;
    public Pair(char a, int b){
        this.a = a;
        this.b = b;
    }
}