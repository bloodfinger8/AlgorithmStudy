package Backjoon;

import java.util.*;

public class P10816 {
    public void solution() {
        int n, m;

        Scanner input = new Scanner (System.in);
        n = input.nextInt();

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numList.add(input.nextInt());
        }

        m = input.nextInt();

        List<Long> checkNumList = new ArrayList<>();
        for(int j = 0; j < m; j++) {
            Integer temp = input.nextInt();
            checkNumList.add(numList.stream().filter(num -> num == temp).count());
        }

        for(Long num : checkNumList){
            System.out.print(num.intValue() + " ");
        }
    }
}
