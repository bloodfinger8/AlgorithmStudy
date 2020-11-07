import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n, k;
        int currentIdx = 0;
        int coinCount = 0;
        Integer[] coins;

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        coins = new Integer[n];

        k = input.nextInt();

        for(int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());

        while (k > 0) {
            for(int i = currentIdx; i < n; i++) {
                if(coins[i] <= k) {
                    k -= coins[i];
                    currentIdx = i;
                    coinCount++;
                    break;
                }
            }
        }

        System.out.println(coinCount);
    }
}