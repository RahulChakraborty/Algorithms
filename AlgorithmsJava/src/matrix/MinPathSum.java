package matrix;

import java.text.DecimalFormat;

/**
 * Created by rahulchakraborty on 8/13/16.
 *
 *Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 */
public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        return dfs(0,0,grid);
    }

    public  static int dfs(int i, int j, int[][] grid){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }

        if(i<grid.length-1 && j<grid[0].length-1){
            int r1 = grid[i][j] + dfs(i+1, j, grid);
            int r2 = grid[i][j] + dfs(i, j+1, grid);
            return Math.min(r1,r2);
        }

        if(i<grid.length-1){
            return grid[i][j] + dfs(i+1, j, grid);
        }

        if(j<grid[0].length-1){
            return grid[i][j] + dfs(i, j+1, grid);
        }

        return 0;
    }
    static void printPath(int sol[][]){
        DecimalFormat oneDigit = new DecimalFormat("00");
        for(int i = 0; i<sol.length;i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(" "+oneDigit.format(sol[i][j]));
            }
            System.out.println();
        }

    }

    public static int minPathSumWithDP(int[][] grid) {
        if(grid == null || grid.length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // initialize top row
        for(int i=1; i<n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // initialize left column
        for(int j=1; j<m; j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        // fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else{
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }
        printPath(dp);
        return dp[m-1][n-1];
    }
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};

        //  Arrays.stream(arr).forEach(e->System.out.print(e));

        int matrix[][] =
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(minPathSum(matrix));
        System.out.println(minPathSumWithDP(matrix));

    }


}
