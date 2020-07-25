import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int[] Input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        TreeSet<Integer> treeSet = new TreeSet<>(); //이진트리 사용

        treeSet.addAll(list);

        System.out.println(treeSet.headSet(Input[1]).size() + 1); // n번째 원소를 뽑아내기
    }
}
