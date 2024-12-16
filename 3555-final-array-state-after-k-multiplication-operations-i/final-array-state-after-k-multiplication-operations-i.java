class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); 
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }

        while (k-- > 0) {
            int[] smallest = pq.poll();
            smallest[0] *= multiplier;
            pq.add(smallest);
        }

        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            nums[entry[1]] = entry[0];
        }
        return nums;
    }
}