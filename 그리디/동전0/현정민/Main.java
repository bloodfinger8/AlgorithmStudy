import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coinArr = new int[input[0]];
        for(int i = 0; i < input[0]; i++){
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        int money = input[1];
        int idx = coinArr.length-1;
        int answer = 0;
        while(money > 0){
            if(money == 0) {
                break;
            } else {
                if(money >= coinArr[idx]) {
                    answer += money/coinArr[idx];
                    money %= coinArr[idx];
                } else {
                    idx--;
                }
            }
        }
        System.out.println(answer);
    }

}
