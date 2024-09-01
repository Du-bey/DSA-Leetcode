class Solution {
    public int ladderLength(String begin, String end, List<String> list) {
        int n1 = list.size();
        if(!list.contains(end)) return 0;
        HashSet<String> h = new HashSet<>();
        for(int i =0;i<n1;i++){
            h.add(list.get(i));
        }
        h.remove(begin);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int lev = p.level;

            if(s.equals(end)) return lev;

            int n = s.length();
            for(int i =0;i<n;i++){
                char[] c= s.toCharArray();
                for(char ch ='a';ch<='z';ch++){
                    c[i] = ch;
                    String s2 = new String(c);
                    if(h.contains(s2)){
                        h.remove(s2);
                        q.add(new Pair(s2, lev + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int level;
    public Pair(String s, int level){
        this.s = s;
        this.level = level;
    }
}