import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1783
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;
        if(N == 1){
            answer = 1;
        } else if (N == 2) {
            answer = Math.min(4, (M + 1) / 2);
        } else if (M < 7) {
            answer = Math.min(4, M);
        } else {
            answer = 5 + (M- 7 );
        }

        System.out.println(answer);
    }


}
