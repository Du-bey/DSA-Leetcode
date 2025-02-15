class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int a = nums1[i];
                int b = nums2[j];
                int sum = a + b;
                if(pq.size() < k) pq.add(new int[]{sum, a, b});
                else if(sum < pq.peek()[0]){
                    pq.poll();
                    pq.add(new int[]{sum, a, b});
                }
                else break;
            }
        }
        while(k -- > 0){
            List<Integer> l = new ArrayList<>();
            int[] arr = pq.poll();
            l.add(arr[1]);
            l.add(arr[2]);
            ans.add(l);
        }
        return ans;
    }
}