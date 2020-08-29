import java.util.*;

public class Main {
    public static void main(String[] args) {
        int countryCount, planeCount, testCount;
        int answer = 0;

        Scanner input = new Scanner(System.in);

        testCount = input.nextInt();
        for(int i = 0; i < testCount; i++) {
            countryCount = input.nextInt();
            planeCount = input.nextInt();

            for(int j = 0; j < planeCount; j++) {
                input.nextInt(); input.nextInt();
            }
            
            answer = countryCount - 1;
            System.out.println(answer);
        }
    }
}
