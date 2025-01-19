class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((s, t) -> t.a - s.a); 

        if(a > 0) pq.add(new Pair(a, 'a'));
        if(b > 0) pq.add(new Pair(b, 'b'));
        if(c > 0) pq.add(new Pair(c, 'c'));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int len = p.a;
            char ch = p.b;
            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch){
                if(pq.isEmpty()) break;
                Pair p2 = pq.poll();
                int len2 = p2.a;
                char c2 = p2.b;
                sb.append(c2);
                len2--;
                if(len2 > 0){
                    pq.add(new Pair(len2, c2));
                }
                pq.add(p);
            }
            else{
                sb.append(ch);
                len--;
                if(len > 0) pq.add(new Pair(len, ch));
            }
        }
        return sb.toString();
    }
}

class Pair{
    int a;
    char b;
    public Pair(int a , char b){
        this.a = a;
        this.b = b;
    }
}