package AlgorithmStudy.스택큐;

import java.util.Stack;

public class TestStack {
	
	int vPosition = 0;
	
	public String solution(String p) {
        String answer = "";
        
        if(p.isEmpty()) { //조건 1
        	return p;
        }
        
        boolean chk = check(p); //조건 2
        String u = p.substring(0,vPosition);
        String v = p.substring(vPosition, p.length());
        
        if(chk) { //조건 3
        	return u + solution(v); //조건 3-1
        }
        
        answer = "(" + solution(v) + ")"; //조건 4-1 ~ 4-3
        
        for (int i = 1; i < u.length()-1; i++) { //조건 4-4
			if(u.charAt(i) == '(' ) {
				answer += ")";
			}else {
				answer += "(";
			}
		}
        
        return answer;
    }
	
	//"올바른 괄호 문제열" 인지 판단하는 함수
	public boolean check(String p) {
		boolean check = true ;
		int start = 0;
		int end = 0;
		
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				start++;
				st.push('(');
			}else {
				end++;
				if(st.isEmpty()) {
					check = false;
				}else {
					st.pop();
				}
			}
			if( start == end ) { 
				vPosition = i+1;
				return check;
			}
			
		}
		return check;
	}
	
	

	public static void main(String[] args) {
		TestStack t = new TestStack();
		System.out.println(t.solution(")("));
		
		
	}

}
