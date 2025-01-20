class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, Pair> h = new HashMap<>();
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                int x = mat[i][j];
                h.put(x , new Pair(i, j));
                
                row[i] += x;
                col[j] += x;
            }
        }

        for(int i =0;i<arr.length;i++){
            int x = arr[i];
            Pair p = h.get(x);
            int r = p.r;
            int c = p.c;

            row[r] -= x;
            col[c] -= x;
            if(row[r] == 0 || col[c] == 0) return i;
        }
        return -1;
    }
}

class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}