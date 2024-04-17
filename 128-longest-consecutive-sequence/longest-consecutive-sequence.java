class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        HashSet<Integer> h = new HashSet<>();
        for(int num : nums){
            h.add(num);
        }
        for(int num : h){
            if(!h.contains(num-1)){
                int size = 0;
                while(h.contains(num)){
                    size++;
                    num++;
                }
                longest = Math.max(longest, size);
            }
        }

        return longest;
    }
}