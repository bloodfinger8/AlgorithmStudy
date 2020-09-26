import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


class Print{
    private int priority ;
    private int order;

    public Print(int print, int order){
        this.priority = print;
        this.order = order;
    }

    public int getPriority(){
        return this.priority;
    }

    public int getOrder(){
        return this.order;
    }
}
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int[] documents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] inputQ = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            LinkedList<Print> printQueue = new LinkedList<>();

            for(int j = 0; j < documents[0]; j++){
                printQueue.add(new Print(inputQ[j],j));
            }

            while(!printQueue.isEmpty()){
                Print front = printQueue.get(0);
                printQueue.remove(0);
                boolean priorFlag = false;
                if(!printQueue.isEmpty()){
                    for(int j = 0; j < printQueue.size(); j++){
                        if(front.getPriority() < printQueue.get(j).getPriority()) {
                            priorFlag = true;
                            break;
                        }
                        if((j+1) == printQueue.size())
                            priorFlag = false;
                    }
                }
                if(priorFlag) {
                    printQueue.add(printQueue.size(),front);
                } else {
                    count++;
                    if(front.getOrder() == documents[1]) {
                        System.out.println(count);
                        break;
                    }
                }
            }

        }

    }

}
