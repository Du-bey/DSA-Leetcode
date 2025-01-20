class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, Integer> h = new HashMap<>();

        for(int i =0;i<arr.length;i++){
            h.put(arr[i], i);
        }

        int ans = arr.length;
        for(int i =0;i<mat.length;i++){
            int temp = -1;
            for(int j =0;j<mat[0].length;j++){
                int x = mat[i][j];
                int ind = h.get(x);
                temp = Math.max(temp, ind);
            }
            ans = Math.min(temp, ans);
        }
        
        for(int j =0;j<mat[0].length;j++){
            int temp = -1;
            for(int i =0;i<mat.length;i++){
                int x = mat[i][j];
                int ind = h.get(x);
                temp = Math.max(temp, ind);
            }
            ans = Math.min(temp, ans);
        }
        return ans;
    }
}