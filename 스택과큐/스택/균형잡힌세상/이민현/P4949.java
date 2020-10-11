package Backjoon;

import java.util.Scanner;
import java.util.Stack;

public class P4949 {
    static final String YES = "yes";
    static final String NO = "no";

    // public void solution() {
    //     String sentence;
    //     Stack<Character> stack = new Stack<>();

    //     Scanner input = new Scanner(System.in);

    //     while(true) {
    //         sentence = input.nextLine();
    //         if(sentence.equals(".")) break;

    //         boolean isBalanced = true;
    //         char text;

    //         for(int i = 0; i < sentence.length(); i++) {
    //             text = sentence.charAt(i);

    //             if(text == '(' || text == '[') {
    //                 stack.push(text);
    //             } else if (text == ')') {
    //                 if(stack.isEmpty() || stack.pop() != '(') {
    //                     isBalanced = false;
    //                     break;
    //                 }
    //             } else if (text == ']') {
    //                 if(stack.isEmpty() || stack.pop() != '[') {
    //                     isBalanced = false;
    //                     break;
    //                 }
    //             }
    //         }

    //         if(!stack.isEmpty()) isBalanced = false;
    //         System.out.println(isBalanced ? YES : NO);
    //         stack.clear();
    //     }
    // }

    public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String sentence = sc.nextLine();
            System.out.println(isBalanced(sentence) ? "YES" : "NO");
        }

    }
    public static boolean isBalanced(String sentence) {
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<sentence.length() ; i++) {
            char c = sentence.charAt(i);
            if(c == '(' || c == '[') {
                st.push(c);
            } else if(c == ')') {
                if(st.isEmpty()) return false;
                char c2 = st.pop();
                if(c2 != '(') return false;

            } else if(c == ']') {
                if(st.isEmpty()) return false;
                char c2 = st.pop();
                if(c2 != '[') return false;
            }
        }
        return st.isEmpty();
    }
}
}
