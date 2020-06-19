package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rahulchakraborty on 7/16/16.
 */

/*

LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.


 Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1])
 be the length of LCS of the two sequences X and Y.

 Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

If last characters of both sequences match (or X[m-1] == Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])

Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)

2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )



 */
public class LongestCommonSequence {

    public static int lcs(char[] seq1, char[] seq2, int seq1Length, int seq2Length){

        if (seq1Length==0 || seq2Length==0){
            return 0;
        }
        if(seq1[seq1Length-1]== seq2[seq2Length-1]){
            return 1+ lcs(seq1,seq2,seq1Length,seq2Length);
        }
        else
            return max(lcs(seq1,seq2,seq1Length,seq2Length-1),lcs(seq1,seq2,seq1Length-1,seq2Length));

    }

    public static int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public static int getLongestCommonSubsequence(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first Sequence");
        String seq1= br.readLine();
        System.out.println("Enter the second Sequence");
        String seq2= br.readLine();
        seq2.contains("abc");

        char[] seqArray1 = seq1.toCharArray();
        char[] seqArray2 = seq2.toCharArray();

        System.out.println("Length of LCS "+lcs(seqArray1,seqArray2,seqArray1.length,seqArray2.length));
    }
}
