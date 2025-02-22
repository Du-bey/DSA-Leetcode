class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        List<String> board = new ArrayList<>(Collections.nCopies(n, ".".repeat(n)));
        solve(board, 0, n);
        return ans;
    }

    public void solve(List<String> board, int r, int n){
        if(r >= n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int c = 0; c< n;c++){
            if(isValid(r, c, board, n)){
                char[] rowArr = board.get(r).toCharArray();
                rowArr[c] = 'Q';
                board.set(r, new String(rowArr));
                solve(board, r + 1, n);
                rowArr[c] = '.';
                board.set(r, new String(rowArr));
            }
        }
    }

    public boolean isValid(int r, int c, List<String> board, int n){
        for(int i =0;i<r;i++){
            if(board.get(i).charAt(c) == 'Q') return false;
        }

        for(int i = r - 1, j = c - 1; i>=0 && j>= 0;i--,j--){
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        for(int i = r - 1, j = c + 1; i>=0 && j<n;i--,j++){
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }
}