package graphs;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] directions = {{-1,0},{0,1},{0,-1},{1,0}};
        int numOfIslands = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j, directions);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(char[][] grid, int i, int j, int[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i<0 || j<0 || i>=rows || j>=cols || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int[] direction: directions) {
            int row = i+direction[0];
            int col = j+direction[1];
            dfs(grid, row, col, directions);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = solution.numIslands(grid);
        System.out.println("Number of islands: " + result);
    }
}