class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        char[] del = {'A', 'C', 'G', 'T'};
        for(String s : bank){
            set.add(s);
        }
        if(!set.contains(end)) return -1;
        set.remove(start);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int d = p.d;
    
            if(s.equals(end)) return d;
            for(int i =0;i<8;i++){
                char[] carr = s.toCharArray();
                for(int ind = 0;ind<4;ind++){
                    carr[i] = del[ind];
                    String news = new String(carr);
                    if(set.contains(news)){
                        q.add(new Pair(news, d + 1));
                        set.remove(news);
                    }
                }
            }
        }
        return -1;
    }
}


class Pair{
    String s;
    int d;
    public Pair(String s, int d){
        this.s = s;
        this.d = d;
    }
}