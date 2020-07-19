package AlgorithmStudy.검색.이진탐색.수찾기_1920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public int sol(List<Integer> list,int target) {
		int check = 0;
		
		//이진탐색 로직
		int low = 0;
		int high = list.size()-1;
		
		while(low <= high) {
			int mid = (low + high) / 2 ;
			int guess = list.get(mid);
			
			if(guess == target) {
				return 1;
			}else if(guess > target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
		return check;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		List<Integer> dataList = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			dataList.add(scan.nextInt());
		}
		
		int m = scan.nextInt();
		int [] searchArr = new int[m];
		
		for (int i = 0; i < m; i++) {
			searchArr[i] = scan.nextInt();
		}
		
		//정렬
		Collections.sort(dataList);
		
		Main s = new Main();
		for (int i = 0; i < m; i++) {
			System.out.println(s.sol(dataList,searchArr[i]));
		}
	}
	

}
