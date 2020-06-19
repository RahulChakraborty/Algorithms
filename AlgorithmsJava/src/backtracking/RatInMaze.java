package backtracking;

import java.text.DecimalFormat;

/**
 * Created by rahulchakraborty on 7/31/16.
 */
class maze{

    boolean solveMaze(int matrix[][],int n){
        int sol[][] = new int[n][n];
        //start finding the path
        if(!solveMazeUtil(matrix,0,0,sol,n)){
            return false;
        }
        //print the solution
        printPath(sol);
        return true;
    }
    void printPath(int sol[][]){
        DecimalFormat oneDigit = new DecimalFormat("0");
        for(int i = 0; i<sol.length;i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(" "+oneDigit.format(sol[i][j]));
            }
            System.out.println();
        }

    }
    //tells that current location is safe or not
    boolean isSafe(int matrix[][],int i,int j,int n){
        if(i<n && i>=0 && j<n && j>=0 && matrix[i][j] == 1)
            return true;
        else
            return false;

    }
    boolean solveMazeUtil(int matrix[][],int x,int y,int sol[][],int n){

        //path complete (if we are at our goal then path complete)
        if(x == n-1 && y == n-1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(matrix,x,y,n) == true)
        {
            sol[x][y] = 1;
            // try right
            if(solveMazeUtil(matrix,x+1,y,sol,n))
                return true;

            //try down
            if(solveMazeUtil(matrix,x,y+1,sol,n))
                return true;

            //try left
            if(solveMazeUtil(matrix,x-1,y,sol,n))
                return true;

            //try up

            if(solveMazeUtil(matrix,x,y-1,sol,n))
                return true;

            //no case match so return false
            sol[x][y] = 0;
            return false;
        }
        return false;

    }

}
class RatInMaze{
    public static void main(String args[]){
        int matrix[][] = new int[][]{
                {1,1,1,0,0},
                {0,0,1,1,0},
                {1,0,0,1,0},
                {1,1,0,1,1},
                {1,1,0,0,1}
        };
        maze m = new maze();
        // size of maze 5*5
        m.solveMaze(matrix,5);

    }
}
