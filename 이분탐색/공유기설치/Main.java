import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2110
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] connArr = new int[input[0]];
        for(int i = 0; i<input[0]; i++){
            connArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(connArr);

        int left = 1;
        int right = connArr[input[0] - 1] - connArr[0];
        int gap = 0;
        int answer = 0;

        while(left <= right){
            int mid= (left + right) /2;
            int start = connArr[0];
            int count =1;
            for (int i = 0; i < input[0] ; i++) {
                gap = connArr[i]-start;
                if(gap >= mid){
                    count++;
                    start = connArr[i];
                }
            }

            if(count >= input[1]){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(answer);

    }

}
