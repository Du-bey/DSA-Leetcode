class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>(9);
        Map<Integer, Set<Character>> rows = new HashMap<>(9);
        Map<Integer, Set<Character>> squares = new HashMap<>(9);

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int squareKey = (r / 3) * 3 + (c / 3);
                
                rows.putIfAbsent(r, new HashSet<>(9));
                cols.putIfAbsent(c, new HashSet<>(9));
                squares.putIfAbsent(squareKey, new HashSet<>(9));

                if (!rows.get(r).add(board[r][c]) ||
                    !cols.get(c).add(board[r][c]) ||
                    !squares.get(squareKey).add(board[r][c])) {
                    return false;
                }
            }
        }
        return true;


    }
}
