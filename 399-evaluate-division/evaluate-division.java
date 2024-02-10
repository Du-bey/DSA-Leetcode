class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> h = new HashMap<>();
        int en = equations.size();
        int qn = queries.size();
        double[] ans = new double[qn];
        for(int i= 0;i<en;i++){
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double val = values[i];
            h.putIfAbsent(s1, new ArrayList<>());
            h.putIfAbsent(s2, new ArrayList<>());
            h.get(s1).add(new Pair(s2,val));
            h.get(s2).add(new Pair(s1,1/val));
        }

        for(int i =0;i<qn;i++){
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            ans[i] = dfs(s1, s2, h, new HashSet());
        }
        return ans;
    }

    public double dfs(String s1, String s2, HashMap<String, List<Pair>> h, Set<String> s){
        if(!h.containsKey(s1) || !h.containsKey(s1)) return -1.0;
        if(s1.equals(s2)) return 1.0;
        s.add(s1);
        for(Pair p : h.get(s1)){
            if(!s.contains(p.first)){
                double ans = dfs(p.first, s2, h, s);
                if(ans != -1.0){
                    return ans * p.second;
                }
            }
        }
        return -1;
    }
}

class Pair{
    String first;
    double second;

    public Pair(String first, double second){
        this.first = first;
        this.second = second;
    }
}