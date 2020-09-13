package DFS.후보키.장지수;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42890
public class Solution {
    static int answer = 0;
    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };
        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) {
        List<Integer> keyCombination = new ArrayList<>();
        keyCombination.add(0);
        checkCandidateKey(relation, 0, keyCombination);
        return answer;
    }

    public static void checkCandidateKey(String[][] relation, int keyIndex, List<Integer> keyCombination) { // 0~3 (현재 선택된 기준키)
        if(keyIndex == relation.length) { // 재귀 종료 조건. keyIndex가 끝에 모두 도달했으면?
            return;
        }

        // visited check

        Set<String> checkUnique = new HashSet<>();

        // 1. Set에 경우의 수 조합 문자열을 넣는다.
        for(int i=0 ; i<relation.length ; i++) {
            StringBuilder st = new StringBuilder();
            for(int j=0 ; j<keyCombination.size() ; j++) {
                st.append(relation[i][j]);
            }
            checkUnique.add(st.toString());
        }
        if(checkUnique.size() == relation.length) { // 사이즈가 같으면 후보키이다. (combination 종료 조건)
            answer++;
            // TODO: visited 체크
            List<Integer> list = new ArrayList<>();
            list.add(keyIndex + 1);
            checkCandidateKey(relation, keyIndex + 1, list); // 검사할 키값을 다음 키로 넘어간다.
        } else {
            // 검사할 키 값을 현재 키 + 다음 키들과의 조합(다른 경우이 수)으로 다시 재귀 호출.
            if(keyCombination.size() == relation.length) { // 조합이 끝났으면
                List<Integer> list = new ArrayList<>();
                list.add(keyIndex + 1);
                checkCandidateKey(relation, keyIndex + 1, list); // 검사할 키값을 다음 키로 넘어간다.
            } else { // 조합이 아직 남았으면
                keyCombination.add(keyIndex + 1);
                checkCandidateKey(relation, keyIndex, keyCombination);
            }
        }
    }

    // 1. 학번 / 이름 / 전공 / 학년 조합의 경우의 수를 구한다.
    // 2. 각 경우의 수를 기준 키로 두고 경우의 수 값을 Set에 넣는다. (학번, 학번 + 이름, 학번 + 전공 ... 학번 + 이름 + 전공 ...)
    // 3. String 배열의 length와 Set의 size가 같으면 unique 보장되어 answer를 증가시키고 다음 키로 넘어간다.
    // 4. 둘의 사이즈가 다르면 중복이 생긴거므로 현재 기준 키와 다른 키와의 조합으로 다시 구한다.
}

