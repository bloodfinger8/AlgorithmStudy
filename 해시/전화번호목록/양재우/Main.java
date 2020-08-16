package 해시;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


//    public boolean solution(String[] phone_book) {
//        boolean answer = true;
//        Arrays.sort(phone_book);
//
//        for(int i=0; i<phone_book.length-1; i++) {
//            boolean check = phone_book[i+1].startsWith(phone_book[i]);
//            if(check) {
//                answer = false;
//                break;
//            }
//        }
//        return answer;
//    }
//    테스트 1 〉	통과 (0.48ms, 50.3MB)
//    테스트 2 〉	통과 (0.52ms, 52.2MB)
//    테스트 3 〉	통과 (0.86ms, 52.4MB)
//    테스트 4 〉	통과 (0.54ms, 52.4MB)
//    테스트 5 〉	통과 (0.48ms, 50.2MB)
//    테스트 6 〉	통과 (0.57ms, 53MB)
//    테스트 7 〉	통과 (0.51ms, 52.5MB)
//    테스트 8 〉	통과 (0.52ms, 52.2MB)
//    테스트 9 〉	통과 (0.82ms, 50.8MB)
//    테스트 10 〉	통과 (0.94ms, 54.5MB)
//    테스트 11 〉	통과 (0.69ms, 50.6MB)
//    효율성  테스트
//    테스트 1 〉	통과 (21.27ms, 59.7MB)
//    테스트 2 〉	통과 (22.10ms, 59.1MB)


    //trie 알고리즘

    public static boolean solution(String[] phone_book) throws Exception {
        boolean answer = true;
        HashMap<String,String> table = new HashMap<>();

        for(int i=0;i<phone_book.length;i++)
            table.put(phone_book[i],phone_book[i]);

        for(String phone_number : phone_book){
            for(int i=1; i<phone_number.length(); i++){
                if(table.containsKey(phone_number.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }
//    테스트 1 〉	통과 (0.75ms, 42.9MB)
//    테스트 2 〉	통과 (0.59ms, 42.4MB)
//    테스트 3 〉	통과 (0.51ms, 42.7MB)
//    테스트 4 〉	통과 (0.76ms, 43.1MB)
//    테스트 5 〉	통과 (0.58ms, 42.9MB)
//    테스트 6 〉	통과 (0.53ms, 42.6MB)
//    테스트 7 〉	통과 (0.57ms, 42.9MB)
//    테스트 8 〉	통과 (0.58ms, 42.5MB)
//    테스트 9 〉	통과 (0.84ms, 43.5MB)
//    테스트 10 〉	통과 (0.83ms, 42.5MB)
//    테스트 11 〉	통과 (0.85ms, 43.1MB)
//    효율성  테스트
//    테스트 1 〉	통과 (3.30ms, 50.8MB)
//    테스트 2 〉	통과 (3.41ms, 50.9MB)


    public static void main(String[] args) throws Exception {
        Main m = new Main();
        String [] phone_book = {"119", "97674223", "1195524421"};

        m.solution(phone_book);

    }
}
