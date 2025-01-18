class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> h = new HashSet<>();
        for(String s : wordList){
            h.add(s);
        }
        h.remove(beginWord);
        if(!h.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int l = p.l;
            if(s.equals(endWord)) return l;

            int slen = s.length();
            for(int i =0;i<slen;i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] ch = s.toCharArray();
                    ch[i] = c;
                    String newS = new String(ch);
                    if(h.contains(newS)){
                        h.remove(newS);
                        q.add(new Pair(newS, l +1));
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
