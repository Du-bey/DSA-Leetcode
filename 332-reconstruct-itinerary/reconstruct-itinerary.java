class Solution {

    private HashMap<String, PriorityQueue<String>> map= new HashMap<>();
    private LinkedList<String> res= new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        List<List<String>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            String u = tickets.get(i).get(0);
            String v = tickets.get(i).get(1);
            PriorityQueue<String> temp = map.getOrDefault(u, new PriorityQueue<>());
            temp.add(v);
            map.put(u, temp);
        }
        dfs("JFK");
        return res;
    }

    public void dfs(String src){
        PriorityQueue<String> pq= map.get(src);
        
        while (pq != null && pq.size() > 0){
            String temp= pq.poll();
            dfs(temp);
        }
        res.addFirst(src); 
        return;
    }
}