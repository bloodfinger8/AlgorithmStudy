import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N-> ");
        int N = scan.nextInt();
        scan.nextLine();
        int [] A = new int[N];
        System.out.print("A-> ");
        String aStr = "";
        for(int i = 0; i<N; i++){
            aStr = scan.next();
            A[i] = Integer.valueOf(aStr);
        }

        System.out.print("M-> ");
        int M = scan.nextInt();
        scan.nextLine();
        System.out.print("B-> ");
        int [] B = new int [M];
        String bStr = "";
        for(int i = 0; i<M; i++){
            bStr = scan.next();
            B[i] = Integer.valueOf(bStr);
        }

        solution(N,A,M,B);
    }

    public static void solution(int N, int[] A, int M, int[] B){
        Arrays.sort(A);
        System.out.println("============================");
        for(int i = 0; i<B.length; i++){
            int idx = binarySearch(A,0,A.length-1, B[i]);
            if(idx == -1){
                System.out.println(0 );
            } else {
                System.out.println(1 );
            }
        }

    }

    public static int binarySearch(int[] arr, int start, int end, int value) {
        if (start > end)
            return -1;
        else if (start == end) {
            if (arr[start] == value)
                return start;
            else
                return -1;
        } else {
            int mid = (start + end) / 2;
            if (arr[mid] == value)
                return mid;
            else if (arr[mid] > value)
                return binarySearch(arr, start, mid - 1, value);
            else
                return binarySearch(arr, mid + 1, end, value);
        }
    }
}
