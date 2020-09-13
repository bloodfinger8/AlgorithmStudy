import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        for(int i = 0; i<T; i++) {
            int N = Integer.valueOf(br.readLine());
            int answer = 0;
            answer = solution(N, answer);
            System.out.println(answer);
        }

    }

    public static int solution(int N, int answer){
        if(N == 0) {
            answer++;
            return answer;
        }
        if(N >= 3){
            int M = N - 3;
            answer = solution(M, answer);
        }
        if(N >= 2){
            int M = N - 2;
            answer = solution(M, answer);
        }
        if(N >= 1){
            int M = N - 1;
            answer = solution(M, answer);
        }
        return answer;
    }


}
