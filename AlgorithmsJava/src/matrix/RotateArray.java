package matrix;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by rahulchakraborty on 7/27/16.
 * Rotate array by right
 */
public class RotateArray {

    public static void rotate(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void rotateMatrixBy90Degrees(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    static void printPath(int sol[][]){
        DecimalFormat oneDigit = new DecimalFormat("0");
        for(int i = 0; i<sol.length;i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(" "+oneDigit.format(sol[i][j]));
            }
            System.out.println();
        }

    }
/*

Rotate by +90:

Transpose
Reverse each row


Rotate by -90:
Transpose
Reverse each column


Rotate by +180:

Method 1: Rotate by +90 twice

Method 2: Reverse each row and then reverse each column

Rotate by -180:

Method 1: Rotate by -90 twice

Method 2: Reverse each column and then reverse each row

Method 3: Reverse by +180 as they are same

 */

    public static int[][] transposeAndReverseRow(int matrix[][]){
        int m =matrix.length;
        int n= matrix[0].length;
        int[][] temp = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                temp[j][i]=matrix[i][j];
            }
        }

        //reverse each row

        int t=0, len =temp[0].length,x=0;

        for(int i=0;i<temp.length;i++) {
            for (int j = 0; j < (temp[0].length / 2); j++) {
                t = temp[i][len - 1 - j];
                temp[i][len - 1 - j] = temp[i][j];
                temp[i][j] = t;

            }
        }
        return temp;
    }

    public static void main(String args[]){
        int [] arr = {1,2,3,4,5};
        rotate(arr,3);
      //  Arrays.stream(arr).forEach(e->System.out.print(e));

        int matrix[][]={{1,2,3},
                        {4,5,6},
                        {7,8,9}};
    /*    printPath(matrix);
        System.out.println("***********");
     rotateMatrixBy90Degrees(matrix);
        printPath(matrix);*/

        System.out.println("***********");
        printPath(matrix);
        System.out.println("***********");
        printPath(transposeAndReverseRow(matrix));


    }
}
