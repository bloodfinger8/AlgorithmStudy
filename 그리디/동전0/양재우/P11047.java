package HOMEWORK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt( st.nextToken() ); //돈 갯수
        int K = Integer.parseInt( st.nextToken() ); //가진 돈

        int[] arr = new int[N]; //돈 단위
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int count = 0; //최소 돈 갯수

        while(K > 0) {
            for (int i = 0; i < N; i++) {
                if (K < arr[i]) {
                    count++;
                    K = K-arr[i-1];
                    break;
                }else if(i == N-1){ //가진 돈 보다 단위가 작을때 가장큰돈을 빼준다.
                    count++;
                    K = K-arr[N-1];
                }
            }
        }
        System.out.println(count);
    }
}

/*
메모리 : 13664	시간 : 264ms
* */
