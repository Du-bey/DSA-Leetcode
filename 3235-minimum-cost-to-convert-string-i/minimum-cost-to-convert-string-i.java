class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();

        int[][] mat = new int[26][26];
        for(int[] r : mat) Arrays.fill(r, 100000000);
        for(int i =0;i<26;i++){
            mat[i][i] = 0;
        }

        for(int i = 0;i<original.length;i++){
            int a = original[i] - 'a';
            int b = changed[i] - 'a';
            int c = cost[i];

            mat[a][b] = Math.min(mat[a][b], c);
        }

        for(int via = 0;via<26;via++){
            for(int i =0;i<26;i++){
                for(int j =0;j<26;j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        long ans = 0;
        for(int i =0;i<n;i++){
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';

            if(mat[a][b] >= 100000000) return -1;
            ans += mat[a][b];
        }
        return ans;
    }
}