class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        if (hand.length % g != 0) return false;

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int x : hand) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(count.keySet());

        while (!pq.isEmpty()) {
            int start = pq.poll();

            if (count.get(start) == 0) continue;

            int freq = count.get(start);
            for (int i = 0; i < g; i++) {
                int num = start + i;
                if (count.getOrDefault(num, 0) < freq) return false;
                count.put(num, count.get(num) - freq);
                if (count.get(num) == 0) pq.remove(num);
            }
        }
        return true;
    }
}