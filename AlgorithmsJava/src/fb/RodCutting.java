package fb;
/*

Let cutRod(n) be the required (best possible price) value for a rod of length n. cutRod(n) can be written as following.

cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
 */
public class RodCutting
{
    /* Returns the best obtainable price for a rod of
       length n and price[] as prices of different pieces */
    static int cutRod(int price[],int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        int max_val = Integer.MIN_VALUE;
        for (int i = 1; i<=n; i++)
        {
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, price[j] + dp[i-j-1]);
            dp[i] = max_val;
        }

        return dp[n];
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, 2));
    }
}