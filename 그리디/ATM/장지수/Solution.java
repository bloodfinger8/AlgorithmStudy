package 그리디.ATM.장지수;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] arr = new int[num];
        for(int i=0 ; i<num ; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(getMinSum(arr, num));
    }
    public static int getMinSum(int[] arr, int num) {
        int[] arr2 = new int[arr.length];
        int sum = 0;
        Arrays.sort(arr);
        for(int i=0 ; i<arr.length ; i++) {
            sum += arr[i];
            arr2[i] = sum;
        }
        return Arrays.stream(arr2).sum();
    }
}

