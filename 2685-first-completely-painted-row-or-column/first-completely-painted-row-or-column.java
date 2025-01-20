class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Pair> h = new HashMap<>();
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        for(int i =0;i<mat.length;i++){
            row.put(i, 0);
            for(int j =0;j<mat[0].length;j++){
                h.put(mat[i][j] , new Pair(i, j));
                int val = row.get(i);
                val += mat[i][j];
                row.put(i , val);
            }
        }
        
        for(int j =0;j<mat[0].length;j++){
            col.put(j, 0);
            for(int i =0;i<mat.length;i++){
                int val = col.get(j);
                val += mat[i][j];
                col.put(j , val);
            }
        }

        for(int i =0;i<arr.length;i++){
            int x = arr[i];
            Pair p = h.get(x);

            int r = p.r;
            int c = p.c;

            int rsum = row.get(r);
            rsum -= x;
            if(rsum == 0) return i;
            row.put(r, rsum);

            int csum = col.get(c);
            csum -= x;
            if(csum == 0) return i;
            col.put(c, csum);

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