package 스택과큐.큐.캐시.jisoo;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17680
public class Solution {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;
    public static void main(String[] args) {
        String[] cities = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };

        System.out.println(solution(3, cities));

        String[] cities2 = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        };

        System.out.println(solution(5, cities2)); // 50

        String[] cities3 = {"Seoul","Seoul","Seoul","Seoul","Seoul","Seoul","Seoul"};
        System.out.println(solution(1, cities3)); // 52
        System.out.println(solution(3, cities3)); // 11

        String[] cities4 = {"Seoul","Jeju","Seoul","Jeju","Seoul","Jeju","Seoul","Jeju","Seoul","Jeju"};
        System.out.println(solution(1, cities4)); // 50
        String[] cities5 = {"Seoul","seoul","Jeju","Jeju","Seoul","SeouL","Jeju","Jeju"};
        System.out.println(solution(1, cities5)); // 24

        String[] cities6 = {"Seoul","seoul","Jeju","Jeju","Seoul","SeouL","Jeju","Jeju"};
        System.out.println(solution(8, cities6)); // 16

    }
    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * CACHE_MISS;
        int totalScore = 0;
        Queue<String> cache = new LinkedList<>();
        for(int i=0 ; i<cities.length ; i++) {
            String elements = cities[i].toLowerCase();
            if(cache.contains(elements)) { // O(N)
                totalScore += CACHE_HIT;
                // 최신 캐시 위치로 업로드.
                cache.remove(elements);
                cache.add(elements);
            }
            else {
                totalScore += CACHE_MISS;
                if(cache.size() >= cacheSize)
                    cache.poll();
                cache.add(elements);
            }
        }
        return totalScore;
    }
}

