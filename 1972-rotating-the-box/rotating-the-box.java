class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for(int i =0;i<m;i++){
            for(int j =n-1;j>=0;--j){
               ans[j][m - 1 - i] = box[i][j];
            }
        }

        for(int j = 0;j<m;j++){
            int low = n -1;
            for(int i =n-1;i >=0;i--){
                if(ans[i][j] == '#'){
                    ans[i][j] = '.';
                    ans[low--][j] = '#';
                }
                else if(ans[i][j] == '*'){
                    low = i - 1;
                }
            }
        }
        return ans;
    }
}