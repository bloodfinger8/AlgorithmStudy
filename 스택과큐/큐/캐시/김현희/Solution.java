package 스택과큐.큐.캐시.김현희;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5 * cities.length;
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        for(int i=0;i<cities.length;i++){
            cities[i]=cities[i].toLowerCase();
        }
        for(int i=0;i<cities.length;i++){
            //1.캐시에 있나 확인
            String line = cities[i];
            int isOK = list.indexOf(line);
            if(isOK>=0){
                //2.시간측정
                list.remove(line);
                answer+=1;
            }else{
                if(list.size()==cacheSize){
                    list.pollLast();
                }
                answer+=5;
            }
            //3.캐시에 넣기
            list.addFirst(cities[i]);
        }
        return answer;
    }
}