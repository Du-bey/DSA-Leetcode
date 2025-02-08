class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character, Integer> h = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            int val = c - 'a';
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        h.forEach((key, value) -> pq.add(new Pair(key, value)));
        char last = '0';
        int frequency = pq.peek().freq;
        if(frequency > (n+1) / 2) return "";

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            char c = p.c;
            int freq = p.freq;
            if(c != last){
                sb.append(c);
                freq--;
                if(freq > 0){
                    pq.add(new Pair(c, freq));
                }
                last = c;
            }
            else{
                Pair p2 = pq.poll();
                char c2 = p2.c;
                int freq2 = p2.freq;
            
                sb.append(c2);
                freq2--;
                if(freq2 > 0){
                    pq.add(new Pair(c2, freq2));
                }
                last = c2;
                pq.add(p);
            }
        }
        return sb.toString();
    }
}

class Pair{
    char c;
    int freq;

    public Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}