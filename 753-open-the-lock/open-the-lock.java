class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<Pair> q = new LinkedList<>();
        String st = "0000";
        q.add(new Pair(st, 0));
        Set<String> vis = new HashSet<>();
        for(String s : deadends){
            vis.add(s);
        }
        if(vis.contains(st)) return -1;
        vis.add(st);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.first;
            int move = p.second;
            if(s.equals(target)) return move;

            List<String> child = generateChildren(s);
            for(String ch : child){
                if(!vis.contains(ch)){
                    q.add(new Pair(ch, move + 1));
                    vis.add(ch);
                }
            }
        }
        return -1;
    }

    private List<String> generateChildren(String lock) {
        List<String> children = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] digits = lock.toCharArray();
            digits[i] = (char)(((digits[i] - '0' + 1) % 10) + '0');
            children.add(new String(digits));
            digits[i] = (char)(((digits[i] - '0' - 2 + 10) % 10) + '0');
            children.add(new String(digits));
        }
        return children;
    }
}

public class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}