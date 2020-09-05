package HOMEWORK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personNum = Integer.parseInt(br.readLine());
        //시간 저장 리스트
        List<Integer> timeList = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < personNum; i++) {
            timeList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(timeList);
        //각각의 시간
        int total = 0;
        int [] arr = new int[personNum];
        //총 시간
        int totalTime = 0;

        for(int temp=0; temp < personNum ; temp++){
            total += timeList.get(temp);
            arr[temp] = total;
        }

        for(int k : arr){
            totalTime += k;
        }
        System.out.println(totalTime);
    }
}
