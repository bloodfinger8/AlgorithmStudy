import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            if(input.equals("."))
                break;
            if(checkBraclet(input))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static boolean checkBraclet(String input){
        Stack stack = new Stack();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            switch (c){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if(stack.empty()){
                        return false;
                    }else{
                        if((char)stack.peek() == '[')
                            return false;
                        else
                            stack.pop();
                    }
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if(stack.empty()){
                        return false;
                    }else{
                        if((char)stack.peek() == '(')
                            return false;
                        else
                            stack.pop();
                    }
                    break;
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }

}
