class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int n = arr.length;
        for(int i =0;i<n;i++){
            h.put(arr[i], i);
        }
        int max = 0;
        for(int j =1;j<n;j++){
            for(int k = j+1;k<n;k++){
                int len = solve(j, k, h, arr);
                if(len >= 3){
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }

    public int solve(int j, int k, HashMap<Integer, Integer> h, int[] arr){
        int num = arr[k] - arr[j];
        if(h.containsKey(num) && h.get(num) < j){
            int i = h.get(num);
            return 1 + solve(i, j, h, arr);
        }
        return 2;
    }
}