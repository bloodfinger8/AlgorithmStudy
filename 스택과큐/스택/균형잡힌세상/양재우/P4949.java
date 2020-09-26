package 스턕큐;


import java.util.Scanner;
import java.util.Stack;

public class P4949 {
/*
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.
 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            String val = scan.nextLine();
            boolean ck = false;
            if(".".equals(val)){
                return;
            }
            String[] real = val.split("");
            Stack<String> st = new Stack<>();

            for (String k : real) {
                if("(".equals(k) || "[".equals(k)){
                    st.push(k);
                }
                if("]".equals(k) || ")".equals(k)) {
                    if(st.isEmpty()){
                        ck = true;
                        break;
                    }
                    if( "(".equals(st.peek()) && ")".equals(k) ){
                        st.pop();
                    }else if( "[".equals(st.peek()) && "]".equals(k)){
                        st.pop();
                    }
                }
            }

            if(st.isEmpty() && ck == false){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
