package dynamicprogramming;

import strings.StringMatch;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by rahulchakraborty on 7/27/16.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1),tmp=null;

        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
             tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String args[]){
        LongestPalindrome lp = new LongestPalindrome();
        String str =lp.longestPalindrome("ayacbbc");
        System.out.println(" str "+str);


    }
}
