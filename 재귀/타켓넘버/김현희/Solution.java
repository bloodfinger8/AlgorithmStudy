class Solution {
    static int answer = 0;
    static int len = 0;
    public void dfs(int[] numbers, int index, int val, int target){
        if(index==len){
            if(val==target) answer+=1;
            return;
        }
        dfs(numbers,index+1,val+numbers[index],target);
        dfs(numbers,index+1,val-numbers[index],target);
    }
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        dfs(numbers,0,0,target);
        return answer;
    }
}