package 정렬.나이순정렬.장지수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Map.Entry<Integer, String>> entryList = new LinkedList<>();
        for(int i=0 ; i<num ; i++) {
            String[] line = br.readLine().split(" ");
            entryList.add(new AbstractMap.SimpleEntry<>(Integer.parseInt(line[0]), line[1]));
        }
//        entryList.add(new AbstractMap.SimpleEntry<>(21, "Junkyu"));
//        entryList.add(new AbstractMap.SimpleEntry<>(21, "Dohyun"));
//        entryList.add(new AbstractMap.SimpleEntry<>(20, "Sunyoung"));

        entryList.sort(Map.Entry.comparingByKey());
        //quickSort(entryList, 0, entryList.size() - 1);

        for(Map.Entry<Integer, String> entry : entryList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // 사용불가. key값이 같아도 교환됨.
    public static void quickSort(List<Map.Entry<Integer, String>> entryList, int start, int end) {
        if(start == end) return;

        Map.Entry<Integer, String> pivot = entryList.get((start + end) / 2);
        int pStart = start;
        int pEnd = end;

        while(pStart <= pEnd) {
            while(entryList.get(pStart).getKey() < pivot.getKey()) {
                pStart++;
            }
            while(entryList.get(pEnd).getKey() > pivot.getKey()) {
                pEnd--;
            }

            // swap
            if(pStart <= pEnd) {
                Map.Entry<Integer, String> tmp = entryList.get(pStart);
                entryList.set(pStart, entryList.get(pEnd));
                entryList.set(pEnd, tmp);
                pStart++;
                pEnd--;
            }
        }

        if(start <= pStart - 1) quickSort(entryList, start, pStart - 1);
        if(pStart <= end) quickSort(entryList, pStart, end);
    }
}

