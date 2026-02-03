class Solution {
    public List<List<Long>> splitPainting(int[][] s) {
        TreeMap<Integer, Long> h = new TreeMap<>();

        for(int[] r : s){
            int st = r[0];
            int end = r[1];
            int c = r[2];
            h.put(st, h.getOrDefault(st, 0L) + c);
            h.put(end, h.getOrDefault(end, 0L) - c);
        }

        long sum = 0;
        List<List<Long>> ans = new ArrayList<>();
        Integer prev = null;

        for(int k : h.keySet()){
            if(prev != null && sum > 0){
                ans.add(List.of((long) prev, (long) k, sum));
            }
            sum += h.get(k);
            prev = k;
        }
        return ans;
    }
}