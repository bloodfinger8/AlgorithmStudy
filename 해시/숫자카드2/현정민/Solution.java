import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Object;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hash = new HashMap<>();
        String [] input1 = br.readLine().split(" ");
        for(int i = 0; i < input1.length; i++){
            hash.put(input1[i], hash.getOrDefault(input1[i], 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        String [] input2 = br.readLine().split(" ");
        for(int i = 0; i < input2.length; i++){
            System.out.print(hash.getOrDefault(input2[i], 0) + " ");
        }
    }
}
