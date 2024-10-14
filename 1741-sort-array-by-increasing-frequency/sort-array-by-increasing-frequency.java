class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int num : nums){
            h.put(num, h.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                if (h.get(b) != h.get(a)) {
                    return Integer.compare(h.get(b), h.get(a));
                } else {
                    return Integer.compare(a, b);
                }
            }
        );
        for(int key : h.keySet()){
            pq.add(key);
        }
        int[] ans = new int[n];
        int i =n-1;
        while(!pq.isEmpty()){
            int num = pq.poll();
            int freq = h.get(num);
            while(freq -- > 0){
                ans[i--] = num;
            }
        }
        return ans;
    }
}