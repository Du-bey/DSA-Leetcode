class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        set.remove(begin);
        if(!set.contains(end)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int d = p.l;
            if(s.equals(end)) return d;

            int slen = s.length();
            for(int i =0;i<slen;i++){
                for(char ch ='a'; ch <= 'z';ch++){
                    char[] c = s.toCharArray();
                    c[i] = ch;
                    String news = new String(c);
                    if(set.contains(news)){
                        set.remove(news);
                        q.add(new Pair(news, d + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int l;
    public Pair(String s, int l){
        this.s = s;
        this.l = l;
    }
}