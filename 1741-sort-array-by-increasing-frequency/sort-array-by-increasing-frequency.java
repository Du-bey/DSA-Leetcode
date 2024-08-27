class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i =0;i<n;i++){
            int x = nums[i];
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(h.entrySet());
        list.sort((a, b) -> {
            int val = a.getValue().compareTo(b.getValue());
            if(val != 0){
                return val;
            }
            else{
                return b.getKey().compareTo(a.getKey());
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            int value = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.add(value);
            }
        }
        int[] ans = new int[n];
        for(int i =0;i<n;i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}