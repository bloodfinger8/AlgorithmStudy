package 문자열검색;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int solution(String s) {
        int answer = 0;
        int k = 0;
        int [] arr = new int[s.length()/2];

        for (int i = 1; i <= s.length()/2; i++) {
            arr[i-1] = cheking(s,i);
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
        return arr[0];
    }

    public int cheking(String s , int len) {
        int count = 1;
        String total = "";
        for (int i = 0; i < s.length(); i = i+len) {
            String di = "";
            String di2 = "";

            if(s.length() >= i+len ) {
                di = s.substring( i , i+len);
            }else{
                di = s.substring( i );
            }

            if(s.length() >= i+(len*2) ){
                di2 = s.substring(i+len , i+(len*2));
            }

            if(di.equals(di2)) { //같다면
                count++;
            }else{ //다르다면 결과 출력
                if(count != 1)
                    total += (count+"") + di;
                else
                    total += di;
                count = 1;
            }

        }

        return total.length();
    }
//    테스트 1 〉	통과 (59.77ms, 56.3MB)
//    테스트 2 〉	통과 (60.63ms, 55.4MB)
//    테스트 3 〉	통과 (52.22ms, 53.3MB)
//    테스트 4 〉	통과 (56.82ms, 54.1MB)
//    테스트 5 〉	실패 (2.09ms, 52.8MB)
//    테스트 6 〉	통과 (50.74ms, 53MB)
//    테스트 7 〉	통과 (56.34ms, 56.4MB)
//    테스트 8 〉	통과 (61.82ms, 57.4MB)
//    테스트 9 〉	통과 (60.41ms, 55.5MB)
//    테스트 10 〉	통과 (79.24ms, 62.5MB)
//    테스트 11 〉	통과 (53.42ms, 55.2MB)
//    테스트 12 〉	통과 (52.14ms, 55.5MB)
//    테스트 13 〉	통과 (51.77ms, 55.1MB)
//    테스트 14 〉	통과 (58.01ms, 56.9MB)
//    테스트 15 〉	통과 (49.81ms, 54.8MB)
//    테스트 16 〉	통과 (30.59ms, 55.5MB)
//    테스트 17 〉	통과 (75.35ms, 55.3MB)
//    테스트 18 〉	통과 (63.74ms, 58.1MB)
//    테스트 19 〉	통과 (64.74ms, 57.6MB)
//    테스트 20 〉	통과 (69.75ms, 61.7MB)
//    테스트 21 〉	통과 (75.24ms, 62MB)
//    테스트 22 〉	통과 (67.60ms, 59.7MB)
//    테스트 23 〉	통과 (75.02ms, 60MB)
//    테스트 24 〉	통과 (67.58ms, 61.3MB)
//    테스트 25 〉	통과 (66.27ms, 61.7MB)
//    테스트 26 〉	통과 (73.97ms, 59.9MB)
//    테스트 27 〉	통과 (70.08ms, 61.7MB)
//    테스트 28 〉	통과 (49.01ms, 55.5MB)


    public static void main(String[] args) {

        Solution s = new Solution();
        s.solution("abcabcdede");

    }


    /*
     public int solution(String s) {
       int answer = 0;
	        List<String> list = new ArrayList<>();
	        List<Integer> list2 = new ArrayList<>();

	        if(s.length() == 1){
	        	return 1;
	        }

	        for (int i = 1; i <= s.length() / 2; i++) {

	        	int na = s.length() % i;
	        	for (int j = 0; j < s.length() / i; j++) {
	        		String a = s.substring(j*i , j*i+i );
	        		list.add(a);
				}
	        	if(na != 0){
	        		list.add(s.substring(s.length()-na)+"");
	        	}
//	        	System.out.println("list" + i + "번째 - " + list );

	        	String val ="" ;
	        	int check = 1;
	        	for (int j = 0; j < list.size()-1; j++) {
	        		String getSt = list.get(j);
	        		String getSt2 = list.get(j+1);

					if(getSt.equals(getSt2)){
						check++;
						if(j == list.size()-2 ){ //더이상 비교할 대상이 없을때
							if(check == 1){
								val += getSt2;
							}else {
								val += String.valueOf(check) + getSt2;
							}
						}
					}else { //다르다면 그때 기입한다.
						if(check == 1){
							val += getSt;
						}else {
							val += String.valueOf(check) + getSt;
						}
						check = 1;
						if(j == list.size()-2){ //더이상 비교할 대상이 없을때
							if(check == 1){
								val += getSt2;
							}else {
								val += String.valueOf(check) + getSt2;
							}
						}
					}
				}

	        	list2.add(val.length());
	        	//압축 문자열의 길이를 list2에 저장해둔다

	        	list.clear();
			}

//	        저장된  list2 순차 정리
	        Collections.sort(list2);
	        return list2.get(0);
    }

//    테스트 1 〉	통과 (73.52ms, 57.8MB)
//테스트 2 〉	통과 (64.60ms, 55.4MB)
//테스트 3 〉	통과 (68.59ms, 55.5MB)
//테스트 4 〉	통과 (59.98ms, 57.7MB)
//테스트 5 〉	통과 (0.85ms, 50.3MB)
//테스트 6 〉	통과 (64.56ms, 57.2MB)
//테스트 7 〉	통과 (65.45ms, 58.1MB)
//테스트 8 〉	통과 (64.98ms, 57.6MB)
//테스트 9 〉	통과 (69.40ms, 57.9MB)
//테스트 10 〉	통과 (85.76ms, 61.5MB)
//테스트 11 〉	통과 (67.75ms, 57.7MB)
//테스트 12 〉	통과 (62.57ms, 57.9MB)
//테스트 13 〉	통과 (59.70ms, 57MB)
//테스트 14 〉	통과 (67.17ms, 55MB)
//테스트 15 〉	통과 (60.96ms, 57.9MB)
//테스트 16 〉	통과 (43.87ms, 55.7MB)
//테스트 17 〉	통과 (70.48ms, 56.6MB)
//테스트 18 〉	통과 (119.97ms, 56.8MB)
//테스트 19 〉	통과 (72.13ms, 55.7MB)
//테스트 20 〉	통과 (79.95ms, 62.3MB)
//테스트 21 〉	통과 (75.62ms, 59.6MB)
//테스트 22 〉	통과 (84.28ms, 62.7MB)
//테스트 23 〉	통과 (74.92ms, 61.9MB)
//테스트 24 〉	통과 (75.03ms, 62.3MB)
//테스트 25 〉	통과 (86.09ms, 61.8MB)
//테스트 26 〉	통과 (84.57ms, 62.8MB)
//테스트 27 〉	통과 (72.24ms, 59.8MB)
//테스트 28 〉	통과 (67.18ms, 58.4MB)



    * */





}
