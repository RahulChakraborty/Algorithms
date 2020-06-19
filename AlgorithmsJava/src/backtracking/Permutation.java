package backtracking;

/**
 * Created by rahulchakraborty on 7/30/16.
 */
public class Permutation {


    /* * A method exposed to client to calculate permutation of String in Java. */
    public static void permutation(String input) {
        permutation("", input);
    } /* * Recursive method which actually prints all permutations * of given String, but since we are passing an empty String * as current permutation to start with, * I have made this method private and didn't exposed it to client. */

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println("PERMUTATION : "+perm );
        } else {
            for (int i = 0; i < word.length() ;
                 i++){

                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    public static void printInterleave(String s1,String s2){
        String soFar = "";
        printInterleaveUtil(s1,s2,0,0, soFar);
    }

    public static void printInterleaveUtil(String s1, String s2, int l1, int l2, String soFar){
        if(l1 == s1.length() && l2 == s2.length()){
            System.out.println(soFar);
            return;
        }
        if(l1 < s1.length()){
            printInterleaveUtil(s1,s2,l1+1,l2,soFar+s1.charAt(l1));
        }
        if(l2 < s2.length()){
            printInterleaveUtil(s1,s2,l1,l2+1,soFar+s2.charAt(l2));
        }
    }

    public static void main(String[] args) {


        permutation("123");

        String s1 = "abc";
        String s2 = "de";
        printInterleave(s1,s2);
    }

}



