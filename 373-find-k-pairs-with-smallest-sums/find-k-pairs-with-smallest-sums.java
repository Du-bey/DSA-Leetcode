class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<String> vis = new HashSet<>();

        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        vis.add("0,0");

        while (k-- > 0 && !pq.isEmpty()) {
            int[] arr = pq.poll();
            int i = arr[1];
            int j = arr[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < m && vis.add(i + "," + (j + 1))) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            if (i + 1 < n && vis.add((i + 1) + "," + j)) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }
        }

        return ans;
    }
}
