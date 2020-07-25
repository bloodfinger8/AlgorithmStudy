package 재귀.타켓넘버;

public class Solution {
    int answer = 0;

    public void dfs(int[] number , int target , int index){
        if(index == number.length){
            int total = 0;
            for(int i : number){
                total += i;
            }
            if(total == target){
                answer++;
            }
        }else{
            number[index] *= 1;
            dfs(number , target , index + 1 );

            number[index] *= -1;
            dfs(number , target , index + 1);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers , 3 , 0);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1,1,1,1,1} , 3));
    }
}


//public class Solution {
//
//    Node [] nodes;
//
//    //생성자
//    public Solution(int size , int [] arr){
//        int nodeTotal = 0;
//        for (int i = 0; i <= size ; i++) {
//            nodeTotal += Math.pow(2, i);
//        }
//        nodes = new Node[nodeTotal];
//
//        int st = 1;
//        nodes[0] = new Node(0);
//
//        for (int i = 1; i <= size; i++) {
//            for (int j = 1; j <= (int)Math.pow(2, i); j++) {
//                nodes[st] = new Node(arr[i-1]);
//                st++;
//            }
//        }
//        //노드 자동 연결
//        int start = 0;
//        for (int i = 1; i < size; i++) {
//            for (int j = 1; j <= (int)Math.pow(2, i); j++) {
//                Node n1 = nodes[start];
//                Node n2 = nodes[start];
//                n1.adj.add(n2);
//
//                start++;
//            }
//            System.out.println();
//        }
//
//    }
//
//
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int [] arr = {1,2,3};
//        Solution s = new Solution(3 ,arr);
//    }
//}
//
//
//class Node{
//    int number;  //배열 값
////    String operation; //부호
//    LinkedList<Node> adj;
//    boolean marked; //방문 체크
//
//    public Node(int number) {
//        this.number = number;
//        this.marked  = false;
//        adj = new LinkedList<Node>();
//    }
//
//    public int getNumber() {
//        return number;
//    }
//}

/*
*  접근방법 (실패)
*:문제를 읽고 DFS로 문제를 어떻게 해결해야 될까라는 생각을 계속했다.
* 깊이 우선탐색을 하려고 하는데 덧셈과 뺄셈을 어떤방식으로 처리할지 생각이 안떠올랐다.
* 어떤 블로그에서 왼쪽으로 가면 - 오른쪽으로 가면 +로 해결하는 사람이 있길래 거기에서 힌트를 얻었다.
*
* 그래서 첫노드는 0 으로 시작하고 왼쪽으로 가면  -number[0] 오른쪽으로 가면 +number[0]
* 이러한 방식으로 알고리즘을 구성했다.
*
*
* 참고한 접근(성공)
* : 노드 구성에 시간을 낭비하는 것보단 단순히 모든 숫자에 대해서 싹다 더하고 뺴봐라.
*
* */
