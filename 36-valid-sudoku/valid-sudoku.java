class Solution {
    public boolean isValidSudoku(char[][] b) {
        int[] hash = new int[9];
        for(int i =0;i <9;i++){
            for(int j=0;j<9;j++){
                char c = b[i][j];
                if(c != '.'){
                    if(hash[c - '1'] != 0) return false;
                    hash[c - '1']++;
                }
            }
            Arrays.fill(hash, 0);
        }
        for(int j=0;j<9;j++){
            for(int i =0;i <9;i++){
                char c = b[i][j];
                if(c != '.'){
                    if(hash[c - '1'] != 0) return false;
                    hash[c - '1']++;
                }
            }
            Arrays.fill(hash, 0);
        }

        for(int i =0;i <9;i+= 3){
            for(int j=0;j<9;j+=3){
                for(int k = i;k<i+3;k++){
                    for(int l = j;l<j+3;l++){
                        char c = b[k][l];
                        if(c != '.'){
                            if(hash[c - '1'] != 0) {
                                return false;
                            }
                            hash[c - '1']++;
                        }
                    }
                }
                Arrays.fill(hash, 0);
            }
            
        }
        return true;
    }
}
