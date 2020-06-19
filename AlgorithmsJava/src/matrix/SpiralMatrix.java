package matrix;

import java.util.ArrayList;

/**
 * Created by rahulchakraborty on 7/25/16.
 */
public class SpiralMatrix {


    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while (m > 0 && n > 0) {

            //if one row/column left, no circle can be formed
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //below, process a circle

            //top - move right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }

            //right - move down
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x++][y]);
            }

            //bottom - move left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }

            //left - move up
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }

        return result;
    }


// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order. For example, given n = 4,

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int k=1;
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;

        while(k<=n*n){
            for(int i=left; i<=right; i++){
                result[top][i]=k;
                k++;
            }
            top++;

            for(int i=top; i<=bottom; i++){
                result[i][right]=k;
                k++;
            }
            right--;

            for(int i=right; i>=left; i--){
                result[bottom][i]=k;
                k++;
            }
            bottom--;

            for(int i=bottom; i>=top; i--){
                result[i][left] = k;
                k++;
            }
            left++;
        }

        return result;
    }
    public static  void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix spr = new SpiralMatrix();
        ArrayList<Integer> convertedMatrix= spr.spiralOrder(matrix);
        System.out.println("Converted Matrix "+ convertedMatrix);

    }

    //Spiral matrix practice print
    private  ArrayList<Integer> spiralMatrix(int arr[][]) {

        int x = 0, y = 0;
        int m = arr.length;
        int n = arr[0].length;

        ArrayList<Integer> list = new ArrayList<>(m * n);

        while (m > 0 && n > 0) {

            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    list.add(arr[x][y++]);
                    break;
                }
            }
            if (n == 1) {

                for (int i = 0; i < m; i++) {
                    list.add(arr[x++][y]);
                    break;
                }
            }
            // left to right row wise
            for(int i=0;i<n-1;i++){
                list.add(arr[x][y++]);
            }
            //top to bottom column wise
            for(int i=0;i<m-1;i++){
                list.add(arr[x++][y]);

            }
            //right to left
            for(int i =0;i<n-1;i++){
                list.add(arr[x][y--]);
            }

            for(int i=0;i<m-1;i++){
                list.add(arr[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n=n-2;

        }

        return list;

    }

    // Practice given a number fill a matrix in spiral order with nubers from 1 to n2

    public int[][] spiralMatrix(int n){

        int[][] arr = new int[n][n];
        int top =0, bottom=n-1,left =0,right=n-1;
        int k=1;

        while(k<=n*n){

            for(int i=left;i<=right;i++){
                arr[top][i]=k;
                k++;
            }
            top++;
            for(int i=top;i<bottom;i++){
                arr[i][right]=k;
                k++;
            }
            right--;

            for(int i=right;i>=left;i--){
                arr[bottom][i]=k;
                k++;
            }
            bottom--;
            for(int i=bottom;i>=top;i++){
                arr[i][left]=k;
                k++;
            }
            left++;


        }
        return arr;


    }

}