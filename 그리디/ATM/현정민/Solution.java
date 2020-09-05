import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        		int[] pNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        		Arrays.sort(pNum);
        
        		int[] pSum = new int[N];
        		pSum[0] = pNum[0];
        		int answer = pNum[0];
        		
		for(int i = 1; i<N; i++) {
        			pSum[i] = pSum[i-1] + pNum[i];
        			answer += pSum[i];
        		}
        
        		System.out.println(answer);
        
    	}
}
