package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by rahulchakraborty on 8/12/16.
 */
public class LeastNumberOfSquares {

    public static int numSquares(int n) {
        int max = (int) Math.sqrt(n);

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=1; i<=n; i++){
            for(int j=1; j<=max; j++){
                if(i==j*j){
                    dp[i]=1;
                }else if(i>j*j){
                    dp[i]=Math.min(dp[i], dp[i-j*j] + 1);
                }
            }
        }

        return dp[n];
    }

    public static  void main(String []args){

        int value = numSquares(3);
        System.out.print("value "+value);
    }
}
