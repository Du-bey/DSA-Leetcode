class Solution {
    public boolean isValidSudoku(char[][] b) {
        Set seen = new HashSet();
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                char c = b[i][j];
                if(c != '.'){
                    if(!seen.add(c + " in row " + i) ||
                       !seen.add(c + " in column " + j) ||
                       !seen.add(c + " in block " + i/3 + "-" + j/3))
                       return false;
                }
            }
        }
        return true;
    }
}
