class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Pair> queue = new LinkedList<>();
        int[][] cost = new int[m][n];
        
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        queue.add(new Pair(0, 0));
        cost[0][0] = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int x = curr.x, y = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newCost = cost[x][y] + (grid[x][y] == i + 1 ? 0 : 1);

                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}

class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }