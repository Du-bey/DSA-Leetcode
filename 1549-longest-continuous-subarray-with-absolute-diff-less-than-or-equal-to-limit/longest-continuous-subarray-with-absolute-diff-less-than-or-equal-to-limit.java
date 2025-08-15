class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int ans = 0;
        int i =0;
        for(int j =0;j<n;j++){
            int x = nums[j];
            
            while(!min.isEmpty() && min.peekLast() > x) min.pollLast();
            min.addLast(x);
            while(!max.isEmpty() && max.peekLast() < x) max.pollLast();
            max.addLast(x);

            while(max.peekFirst() - min.peekFirst() > limit){
                
                if(max.peekFirst() == nums[i]) max.pollFirst();
                if(min.peekFirst() == nums[i]) min.pollFirst();
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}