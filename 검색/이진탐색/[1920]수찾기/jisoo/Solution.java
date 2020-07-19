package AlgorithmStudy.검색.이진탐색.수찾기_1920.jisoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int n = Integer.parseInt(br.readLine());
        int[] arrInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] numInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(n, arrInput, m, numInput);
        // test cases
        // solution(5, new int[]{4,1,5,2,3}, 5, new int[]{1,3,7,9,5});
        //solution(5, new int[]{4,1,5,2,3}, 7, new int[]{1,3,7,9,5,6,8});
        // solution(5, new int[]{1,1,1,1,1}, 7, new int[]{1,3,7,9,5,6,8});
        // solution(5, new int[]{-4,-1,-5,2,3}, 7, new int[]{-1,3,7,9,-5,6,8});
        // solution2(7, new int[]{4,1,5,2,3,8,6}, 5, new int[]{1,3,7,9,5});
        // solution2(1, new int[]{1}, 2, new int[]{1,1});
    }

    public static void solution(int n, int[] nArray, int m, int[] mArray) {
        Map<Integer, Integer> check = new HashMap<>();
        // if n<m, n==m, n>m case 고려
        for(int i=0 ; i<n ; i++) {
            check.put(nArray[i], check.getOrDefault(nArray[i], 0) + 1);
        }

        for(int i=0 ; i<m ; i++) {
            if(check.containsKey(mArray[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
