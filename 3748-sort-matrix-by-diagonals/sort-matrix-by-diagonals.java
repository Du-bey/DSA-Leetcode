class Solution {
    int n;
    int m;
    public int[][] sortMatrix(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for(int r = 0;r < n;r++){
            sort(r, 0, grid, false);
        }

        for(int c = 1; c<m;c++){
            sort(0, c, grid, true);
        }
        return grid;
    }

    public void sort(int r, int c, int[][] grid, boolean isAsc){
        int i = r;
        int j = c;
        List<Integer> temp = new ArrayList<>();
        while(i < n && j < m){
            temp.add(grid[i++][j++]);
        }
        if(isAsc){
            Collections.sort(temp);
        }
        else{
            temp.sort(Collections.reverseOrder());
        }

        i = r;
        j = c;
        for(int x : temp){
            grid[i][j] = x;
            i++;
            j++;
        }
    }
}