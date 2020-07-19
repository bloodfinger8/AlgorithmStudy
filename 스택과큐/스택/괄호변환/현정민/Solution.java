import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        String answer = "";

        if(p.equals("")){
            return answer;
        }

        answer = splitBracket(p, answer);

        return answer;
    }

    public static String splitBracket(String p,String answer){
        int leftBracket = 0;
        int rightBracket = 0;
        String v = "";
        String u = "";
        if(isRight(p)){
            return p;
        }else{
            for(int i = 0; i<p.length(); i++){
                if(p.charAt(i) == ')'){
                    rightBracket++;
                }
                else if(p.charAt(i) == '('){
                    //answer += p.charAt(i);
                    leftBracket++;
                }
                if(leftBracket == rightBracket){
                    if(p.charAt(0) == ')'){
                        u = p.substring(0,i+1);
                        v = splitBracket(p.substring(i+1),"");
                        answer = answer + "(" + v + ")" + reverse(u.substring(1,u.length()-1));
                        return answer;
                    }else{
                        u = p.substring(0,i+1);
                        answer += u;
                        v = p.substring(i+1);
                        return splitBracket(v,answer);
                    }
                }
            }
        }
        return answer;
    }

    public static boolean isRight(String p){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                stack.push('(');
            }
            else if(p.charAt(i) == ')'){
                if(stack.empty())
                    return false;
                stack.pop();
            }
        }
        if(stack.size() == 0)
            return true;
        else
            return false;
    }

    public static String reverse (String u){
        String temp = "";
        if(u.length() == 0)
            return "";
        for(int i = 0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                temp += ")";
            }
            else if(u.charAt(i) == ')'){
                temp += "(";
            }
        }
        return temp;
    }

}