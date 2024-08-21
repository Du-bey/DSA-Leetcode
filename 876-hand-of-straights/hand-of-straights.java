class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : hand){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        for(int x : hand){
            if(h.get(x) <= 0) continue;
            for(int ind = 1;ind < groupSize;ind++){
                int cnt = h.getOrDefault(x+ind, 0);
                if(cnt > 0){
                    h.put(x + ind, h.get(x + ind) -1);
                }
                else{
                    return false;
                }
            }
            h.put(x, h.get(x) - 1);
        }
        return true;
    }
}