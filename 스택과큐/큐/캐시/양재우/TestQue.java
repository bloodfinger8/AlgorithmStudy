package AlgorithmStudy.스택큐;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TestQue {

	final static int CACHE_HIT = 1; // 기존에 존재 할때
	final static int CACHE_MISS = 5; //새롭게 추가 될때
	
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if( cacheSize == 0 ) {
        	return TestQue.CACHE_MISS * cities.length;
        }
        
        Queue<String> que = new LinkedList<String>();
        Map<String,Integer> cacheBox = new LinkedHashMap<String,Integer>();
        
        for (int i = 0; i < cities.length; i++) {
        	String city = cities[i].toUpperCase();
        	
        	if( cacheBox.get(city) == null ) { 
        		if ( !(cacheBox.size() < cacheSize) ) {
        			cacheBox.remove(que.peek());
					que.poll();
				}
        		cacheBox.put(city,1);
				que.add(city);
        		answer += TestQue.CACHE_MISS;
        	}else {
        		que.remove(city); 
				que.add(city);
				answer += TestQue.CACHE_HIT;
        	}
        	
		}
        return answer;
    }
    
	
	public static void main(String[] args) {
		TestQue t = new TestQue();
		String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork","LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println(t.solution(3, cities));
	}

}
