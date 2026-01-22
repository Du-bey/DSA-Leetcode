class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            l.add(num);
        }

        int ans = 0;
        while(l.size() > 1){ 
            int ind = 0;
            int lsum = 200000;
            boolean isSorted = true;

            for(int i = 0;i< l.size() - 1; i++){
                int sum = l.get(i) + l.get(i+1);

                if(l.get(i) > l.get(i + 1)) isSorted = false;
                if(sum < lsum){
                    lsum = sum;
                    ind = i;
                }
            }

            if(isSorted) break;
            ans++;
            l.set(ind, lsum);
            l.remove(ind + 1);
        }
        return ans;
    }
}