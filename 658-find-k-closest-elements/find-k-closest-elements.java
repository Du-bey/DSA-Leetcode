class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA == diffB) {
                return b - a;
            }
            return diffB - diffA;
        });

        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);

        return result;
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}