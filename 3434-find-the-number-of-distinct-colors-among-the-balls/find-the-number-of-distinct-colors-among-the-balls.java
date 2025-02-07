class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> h = new HashMap<>();
        HashMap<Integer, Integer> arr = new HashMap<>();
        int n = queries.length;
        int[] ans = new int[n];
        int ind = 0;
        for(int[] r : queries){
            int ball = r[0];
            int c = r[1];
            if(arr.containsKey(ball)){
                int prevc = arr.get(ball);
                if(h.containsKey(prevc)){
                    h.put(prevc, h.get(prevc) - 1);
                    if(h.get(prevc) ==  0) h.remove(prevc);
                }
            }
            
            arr.put(ball, c);
            h.put(c, h.getOrDefault(c, 0) + 1);
            ans[ind++] = h.size();
        }
        return ans;
    }
}