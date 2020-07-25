package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

    public static void swap(int[] arr , int start , int end) {
        int k = arr[start];
        arr[start] = arr[end];
        arr[end] = k;
    }

    public static int part(int[] arr , int start , int end) {
        int pivot = arr[(start + end) / 2];

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot ){
                end--;
            }

            if(start <= end){
                swap(arr , start , end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void quick(int [] arr , int start , int end) {
        int part = part(arr , start , end);

        if(start < part-1 ){
            quick(arr , start , part-1);
        }
        if(part < end){
            quick(arr, part , end);
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int target = Integer.parseInt(s[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        quick(arr , 0 , arr.length -1);

        System.out.println(arr[target-1]);
    }
}


/*
*  퀵정렬을 통해서 이용한 풀이
*
*
*
* */