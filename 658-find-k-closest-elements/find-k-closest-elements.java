class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int no : arr){
            pq.add(Math.abs(no - x));
            if(pq.size() > k) pq.poll();
            h.put(no, h.getOrDefault(no, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int no = pq.poll();
            int b = x - no;
            int a = x + no;
            if(h.containsKey(b) && h.get(b) > 0){
                h.put(b, h.get(b) - 1);
                ans.add(b);
            }
            else if(h.containsKey(a) && h.get(a) > 0){
                h.put(a, h.get(a) - 1);
                ans.add(a);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}