class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        int n = hand.length;
        Arrays.sort(hand);
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : hand){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        for(int x : hand){
            if(h.get(x) <= 0) continue;
            for(int i = 1;i<g;i++){
                int cnt = h.getOrDefault(x+i, 0);
                if(cnt > 0){
                    h.put(x+i, cnt - 1);
                }
                else return false;
            }
            h.put(x, h.get(x) - 1);
        }
        return true;
    }
}