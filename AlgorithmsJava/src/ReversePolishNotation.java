import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by rahulchakraborty on 6/25/16.
 */
public class ReversePolishNotation {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" Enetr the rpn expression");

        String sen = br.readLine();
        Stack<Integer> stack = new Stack<Integer>();
        char[] charArray =sen.toCharArray();

        for(int i =0; i< charArray.length ; i++){

            if(charArray[i]=='*'||charArray[i]=='/'||charArray[i]=='+'||charArray[i]=='-'){
                int a = (stack.pop());
                int b = (stack.pop());

                switch (charArray[i]) {
                    case '*':
                        stack.push((a*b));
                        break;
                    case '/':
                        stack.push(a/b);
                        break;
                    case '-':
                        stack.push(a-b);
                        break;
                    case '+':
                        stack.push(a+b);
                        break;

                }
            }
            else {
                stack.push(Integer.parseInt(String.valueOf(charArray[i])));
            }

        }

    System.out.println(" Evaluted Expression "+ stack.pop());

    }
}
