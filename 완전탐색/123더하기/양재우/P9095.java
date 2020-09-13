package REALPRATICE;

import java.util.Scanner;

public class P9095 {

    /*
    https://www.acmicpc.net/problem/9095
3
4
7
10
     */

    static int count = 0;

    static void dfs(int target , int k) {
        if(target < k)
            return;
        if(target == k){
            count++;
            return;
        }

        dfs(target , k+1);
        dfs(target , k+2);
        dfs(target , k+3);

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            count = 0;
            dfs(scan.nextInt(),0 );
            System.out.println(i +" 번째  : " + count);
        }


    }
}
