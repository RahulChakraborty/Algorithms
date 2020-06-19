package strings;

import java.util.Arrays;

/**
 * Created by rahulchakraborty on 7/23/16.
 */
public class ReverseArrayWithoutChangingSpecialCharacters {

    public static void main(String[] args){

        String s = "a,b$c",k=null,n=null;
        char[] array =s.toCharArray();

        int maxRange =(s.length()-1)/2;

        int l =0, r = maxRange, length = s.length();

        while(l<maxRange && r>=0){
            if(s.charAt(l)!='$'||s.charAt(l)!=','){
                char c = s.charAt(r);
                array[r]=array[l];
                array[l]=c;
                l++; r--;
            }
        }
        System.out.println(" str "+ Arrays.toString(array));
    }
}
