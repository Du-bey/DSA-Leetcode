class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> h = new TreeMap<>();

        for(int[] r : trips){
            int p = r[0];
            int in = r[1];
            int out = r[2];

            h.put(in, h.getOrDefault(in, 0) + p);
            h.put(out, h.getOrDefault(out, 0) - p);
        }

        int cap = 0;
        for(Integer k : h.keySet()){
            int val = h.get(k);
            cap += val;
            if(cap > capacity) return false;
        }
        return true;
    }
}