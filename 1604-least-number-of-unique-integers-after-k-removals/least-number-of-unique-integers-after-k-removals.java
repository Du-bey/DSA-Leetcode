class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int x : arr){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }

        int n = arr.length;
        int[] freq = new int[n+1];

        for(int x : h.keySet()){
            freq[h.get(x)]++;
        }

        int cnt = h.size();

        for(int i = 1;i<=n && k > 0;i++){
            if(freq[i] == 0) continue;
            if(i > k) break;

            cnt -= Math.min(freq[i], k/i);
            k -= freq[i] * i;
        }
        return cnt;
    }
}