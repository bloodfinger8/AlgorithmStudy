package 스택과큐.큐.캐시.현정민;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(3,cities));
        String [] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(3,cities2));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        answer = replaceCache(cacheSize, cities);
        return answer;
    }

    public static int replaceCache (int cacheSize, String[] cities){
        Queue<String> queue = new LinkedList<String>();

        int runTime = 0;


        if(cacheSize == 0){
            return cities.length*5;
        }
        if(cities.length == 0){
            return 0;
        }

        for(int i = 0; i<cities.length; i++){
            String tempCity = cities[i].toLowerCase();
            if(queue.contains(tempCity)){
                queue.poll();
                queue.offer(tempCity);
                runTime += 1;
            }else {
                if(queue.size() < cacheSize) {
                    queue.offer(tempCity);
                } else {
                    queue.poll();
                    queue.offer(tempCity);
                }
                runTime += 5;
            }
        }
        return runTime;
    }

}
