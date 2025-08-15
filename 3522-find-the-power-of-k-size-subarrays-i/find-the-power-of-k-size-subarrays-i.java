class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) return nums;
        int n = nums.length;

        int[] res = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        
        int ind = 0;
        for(int i = 0;i< n;i++){
            if(q.size() == k){
                q.pollFirst();
            }

            if(!q.isEmpty() && q.peekLast() + 1 != nums[i]){
                q.clear();
            }

            q.offerLast(nums[i]);
            if(i >= k -1){
                res[ind++] = (q.size() == k) ? q.peekLast() : -1;
            }
        }
        return res;
    }
}