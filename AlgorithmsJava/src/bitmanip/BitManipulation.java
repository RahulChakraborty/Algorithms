package bitmanip;

import com.sun.tools.classfile.Synthetic_attribute;

/**
 * Created by rahulchakraborty on 8/7/16.
 */
public class BitManipulation {

    public static int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
         //   System.out.print(" a= "+a +" x = "+x);
        }
        return x;
    }

    public static int getSum(int a, int b) {

        while(b!=0){
            int c = a&b;
            a=a^b;
            b=c<<1;

            System.out.print(" a = "+a +" b = "+b+" c= "+c);
            System.out.println(" ");
        }

        return a;
    }
    public static void  main(String args[]){
        int[] arr = {1,1,1,1,2,1,1};
        System.out.println(" single number "+singleNumber(arr));

        System.out.println(" sum value "+getSum(5,7));

    }
}
