package strings;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by rahulchakraborty on 7/21/16.
 *
 * txt[]  = "AABCCAADDEE"
 pat[] = "FAA"
 Run on IDE
 The number of comparisons in best case is O(n).

 2) Worst case also occurs when only the last character is different.

 txt[] = "AAAAAAAAAAAAAAAAAB"
 pat[] = "AAAAB"
 Run on IDE
 Number of comparisons in worst case is O(m*(n-m+1))
 m= length of pattern


 */
public class StringMatch {

    public static void main(String args[]) throws Exception {

        System.out.println("enter the String ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        System.out.println("enter the Pattern ");
        String pattern = br.readLine();
        System.out.println("entered values "+ text+" "+pattern);

        for (int i = 0; i < text.length()-pattern.length(); i++) {
            for (int j = 0; j < pattern.length() ; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
                if (j ==pattern.length()-1) {
                    System.out.println("Pattern found at "+i);
                }

            }

        }



    }
}
