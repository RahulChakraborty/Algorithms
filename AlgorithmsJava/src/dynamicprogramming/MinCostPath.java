package dynamicprogramming;

/**
 * Created by rahulchakraborty on 8/2/16.
 *
 * Given a cost matrix cost[][] and a position (m, n) in cost[][],
 *
 * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0)
 */
public class MinCostPath {

    int minCost(int cost[][], int m, int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + min( minCost(cost, m-1, n-1),
                    minCost(cost, m-1, n),
                    minCost(cost, m, n-1) );
    }

    /* A utility function that returns minimum of 3 integers */
    int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
}
