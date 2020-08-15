import java.util.*;
class Solution {
    public int idx = 0; 
       public int solution(String[][] relation) {
        int answer = 0;
        Map<Integer, LinkedList<String>> powerSet= new HashMap<>();
        int row = relation.length;
        int col = relation[0].length;
        if(row == 1 || col == 1){
            return col;
        }
        powerSet(relation, new boolean[row][col], 0, col, powerSet);
        LinkedList<String> minumumCheckList = new LinkedList<>();
        for(int i = 1; i<powerSet.size(); i++){
            LinkedList<String> list = new LinkedList<>();
            LinkedList<String> powerSetList = powerSet.get(i);
            boolean flag = false;
            for(String poswerset : powerSetList){
                //System.out.print(poswerset + " / ");
                if(!list.contains(poswerset)){
                    list.add(poswerset);
                }else{
                    flag = true;
                    break;
                }
            }
            //System.out.println("---------------------------------------" + flag);
            if( minumumCheckList.size() > 0 && list.getFirst().contains(minumumCheckList.getFirst()) ) {
                flag = true;
            }
            if(!flag){
                    answer++;
                //System.out.println("---------------------------------------" + answer);
                minumumCheckList = list;
            }
        }
        return answer;
    }


    public void powerSet(String[][] arr, boolean[][] state, int i, int end, Map<Integer, LinkedList<String>> powerSet) {
        if (i >= end) {
            String[] tempStr = new String[arr.length];
            StringBuffer[] temp = new StringBuffer[arr.length];
            for (int w = 0; w < end; w++) {
                for(int j = 0; j<arr.length; j++){
                    if(temp[j] == null)
                        temp[j] = new StringBuffer();
                    if (state[j][w]) {
                        temp[j] =  temp[j].append(arr[j][w]);
                    }
                }
            }
            LinkedList<String> list = new LinkedList<>();
            for(int j = 0; j<arr.length; j++){
                list.add(temp[j].toString());
                //System.out.println(temp[j].toString());
            }
            powerSet.put(idx++, list);
            //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            return;
        }
        for(int j = 0; j<arr.length; j++){
            state[j][i] = false;
        }
        powerSet(arr, state, i + 1, end, powerSet);

        for(int j = 0; j<arr.length; j++){
            state[j][i] = true;
        }
        powerSet(arr, state, i + 1, end, powerSet);
    }
}

/*
테스트 1 〉	실패 (2.29ms, 43MB)
테스트 2 〉	통과 (1.25ms, 42.8MB)
테스트 3 〉	실패 (2.32ms, 42.6MB)
테스트 4 〉	통과 (1.17ms, 42.7MB)
테스트 5 〉	통과 (1.28ms, 43.1MB)
테스트 6 〉	통과 (0.83ms, 42.9MB)
테스트 7 〉	통과 (1.21ms, 42.7MB)
테스트 8 〉	통과 (1.34ms, 42.8MB)
테스트 9 〉	통과 (1.80ms, 42.6MB)
테스트 10 〉	통과 (1.95ms, 42.7MB)
테스트 11 〉	통과 (2.39ms, 42.8MB)
테스트 12 〉	통과 (7.28ms, 43.2MB)
테스트 13 〉	실패 (6.49ms, 42.8MB)
테스트 14 〉	통과 (1.56ms, 43MB)
테스트 15 〉	통과 (1.54ms, 43MB)
테스트 16 〉	통과 (1.25ms, 43MB)
테스트 17 〉	통과 (1.18ms, 43.1MB)
테스트 18 〉	실패 (18.18ms, 44.3MB)
테스트 19 〉	실패 (10.79ms, 43.9MB)
테스트 20 〉	실패 (18.51ms, 44MB)
테스트 21 〉	통과 (12.21ms, 44.1MB)
테스트 22 〉	실패 (8.29ms, 43.7MB)
테스트 23 〉	통과 (1.62ms, 42.7MB)
테스트 24 〉	실패 (7.75ms, 43.4MB)
테스트 25 〉	실패 (15.76ms, 44.9MB)
테스트 26 〉	실패 (12.75ms, 44.2MB)
테스트 27 〉	실패 (4.02ms, 43.2MB)
테스트 28 〉	실패 (4.75ms, 43.5MB)
*/