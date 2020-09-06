import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        List<Integer> numberList = new LinkedList<>();
        int sum = 0;
        boolean tenflag = false;
        boolean threeflag = false;
        for(int i = 0; i < numbers.length(); i++){
            //numberList.add(Integer.parseInt(number[i]));
            sum = sum + numbers.charAt(i)- '0';
            numberList.add(numbers.charAt(i)- '0');
            if(numbers.charAt(i) == '0')
                tenflag = true;
        }
        if(sum%3 == 0)
            threeflag = true;
        if(! (tenflag &&threeflag)) {
            System.out.println(-1);
            return;
        }
        Collections.sort(numberList, Collections.reverseOrder());

        for(int number : numberList){
            System.out.print(number);
        }

    }
}
