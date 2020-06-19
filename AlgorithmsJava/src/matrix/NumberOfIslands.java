package matrix;

/**
 * Created by rahulchakraborty on 8/14/16.
 *Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    merge(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void merge(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1)
            return;

        grid[i][j] = 5;

        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }
/*

11110
11010
11000
00000
 */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1,0},
                {1, 1, 0, 1,0},
                {0, 1, 0, 0,0},
                {0, 0, 0, 0,0}
        };

        System.out.print(numIslands(arr));



    }
}
