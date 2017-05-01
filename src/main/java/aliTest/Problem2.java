package aliTest;

/**
 * Created by jacky on 17-4-26.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("Since15")
public class Problem2 {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        Stack<String> stack=new Stack<String>();
        int i=0;
        while (i<expr.length()){
            if (String.valueOf(expr.charAt(i)).matches("[0-9]")){
                if (stack.size()==15) {
                    return -2;
                }
                stack.push(String.valueOf(expr.charAt(i)));
            }
            if (expr.charAt(i)=='^'){
                if (stack.size()==0) {
                    return -1;
                }
                String temp=stack.pop();
                Integer m=Integer.parseInt(temp)+1;
                stack.push(String.valueOf(m));
            }
            if (expr.charAt(i)=='*'){
                if (stack.size()==0) {
                    return -1;
                }
                String temp=stack.pop();
                if (stack.size()==0) {
                    return -1;
                }
                String temp2=stack.pop();
                Integer m=Integer.parseInt(temp)*Integer.parseInt(temp2);
                stack.push(String.valueOf(m));
            }
            if (expr.charAt(i)=='+'){
                if (stack.size()==0) {
                    return -1;
                }
                String temp=stack.pop();
                if (stack.size()==0) {
                    return -1;
                }
                String temp2=stack.pop();
                Integer m=Integer.parseInt(temp)+Integer.parseInt(temp2);
                stack.push(String.valueOf(m));
            }
            i++;
        }
        if (stack.size()>0) return Integer.parseInt(stack.pop());
        return -1;
    }
}
