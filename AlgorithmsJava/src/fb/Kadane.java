package fb;

import java.io.*;
// Java program to print largest contiguous array sum
import java.util.*;

class Kadane
{
    public static void main (String[] args)
    {
        int [] a = {-2, -3, -4, 1, 2, -1, -5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int MAX = Integer.MIN_VALUE, intermediateSum = 0;

        for (int i = 0; i < size; i++)
        {
            intermediateSum = intermediateSum + a[i];
            if (MAX < intermediateSum)
                MAX = intermediateSum;
            if (intermediateSum < 0)
                intermediateSum = 0;
        }
        return MAX;
    }
}

