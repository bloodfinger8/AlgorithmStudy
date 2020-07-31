package 정렬.k번째수.장지수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = s.nextInt();
        }

        quickSort(arr, 0, n - 1);
        System.out.println(arr[k - 1]);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(start == end) {
            return;
        }

        int pivot = arr[(start + end) / 2];
        int pStart = start;
        int pEnd = end;

        while(pStart <= pEnd) {
            while(arr[pStart] < pivot) {
                pStart++;
            }
            while(arr[pEnd] > pivot) {
                pEnd--;
            }

            // swap
            if(pStart <= pEnd) {
                int tmp = arr[pStart];
                arr[pStart] = arr[pEnd];
                arr[pEnd] = tmp;
                pStart++;
                pEnd--;
            }
        }

        System.out.println(Arrays.toString(arr));

        quickSort(arr, start, pStart - 1);
        quickSort(arr, pStart, end);
    }
}
