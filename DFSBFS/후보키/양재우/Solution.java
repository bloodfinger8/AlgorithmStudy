package DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        int rowsize = relation.length;
        int colsize = relation[0].length;

        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i < 1<<colsize; ++i){
            if(check(relation , rowsize , colsize , i)){
                candidates.add(i);
            }
        }
        //최소성 만족
        while(!candidates.isEmpty()) {
            int n = candidates.remove(0); //최소성을 만족하는 후보키
            System.out.println(n + " / " +candidates);
            ++answer;

            for (Iterator<Integer> it = candidates.iterator(); it.hasNext();){
                int c = it.next();
                if( (n & c) == n ) //후보키가 속해있다면 삭제
                    it.remove();
            }
        }
        System.out.println(answer);
        return answer;
    }

    private boolean check(String[][] relation, int rowsize, int colsize, int subset) {
        for ( int i = 0; i < rowsize -1 ; ++i) {
            for (int j = i+1; j < rowsize; ++j){
                boolean isSame = true;
                for (int k = 0 ; k < colsize; ++k){
                    if((subset & 1<<k) == 0){
                        continue;
                    }
                    if(relation[i][k].equals(relation[j][k]) == false){
                        isSame = false;
                        break;
                    }
                }
                if(isSame)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String[][] value = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}};

        Solution s = new Solution();
        s.solution(value);
    }
}
