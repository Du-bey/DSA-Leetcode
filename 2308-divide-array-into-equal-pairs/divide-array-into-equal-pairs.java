class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        if(n % 2 == 1) return false;

        HashMap<Integer,Integer> h = new HashMap<>();
        for(int x : nums){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }

        for(int x : h.keySet()){
            if(h.get(x) % 2 != 0) return false;
        }
        return true;
    }
}