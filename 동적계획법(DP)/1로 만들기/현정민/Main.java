import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1463
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] arr = null;
        if(x < 4){
            arr = new int[4];
        }else {
            arr = new int[x + 1];
        }
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for(int i = 4; i<=x; i++){
            int temp3 = Integer.MAX_VALUE;
            int temp2 = Integer.MAX_VALUE;
            int temp1 = arr[i-1] + 1;
            if(i%3 == 0){
                temp3 = arr[i/3] + 1;
            }
            if(i%2 == 0) {
                temp2 = arr[i/2] + 1;
            }

            arr[i] = min(temp1, temp2, temp3);
        }

        System.out.println(arr[x]);
    }

    public static int min(int a, int b, int c){
        int m = a;
        if(m > b || m > c){
            m = b;
            if(m > c){
                m=c;
                return m;
            }
            else{
                return m;
            }
        }
        else{
            return m;
        }
    }

}

/* 답 예시
570 // 정답: 8

571 // 정답: 9

572 // 정답: 10, 오답: 11

642 // 정답: 10, 오답: 11

643 // 정답: 11, 오답: 12

734 // 정답: 9, 오답: 10

740 // 정답: 9, 오답: 10

842 // 정답: 11, 오답: 12
 */