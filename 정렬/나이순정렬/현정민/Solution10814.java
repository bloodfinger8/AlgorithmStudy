import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Member implements Comparable<Member> {
// 참고 : Compare과 Comparator의 차이점
// https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
    private int age;
    private String name;

    public Member(int age, String name){
        this.age=age;
        this.name=name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    @Override //age를 기준으로 비교하기 위해서 Override
    public int compareTo(Member member) {
        return this.age - member.age;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int N = Integer.parseInt(br.readLine());
        //Collections.sort를 사용하기 위해서 ArrayList 선언
        ArrayList<Member> memberList = new ArrayList<Member>();


        for(int i = 0; i<N; i++) {
            String[] Input = br.readLine().split(" ");
            Member tempMember = new Member(Integer.valueOf(Input[0]), Input[1]);
            memberList.add(tempMember); //tempMember를 memberList에 추가
        }

        Collections.sort(memberList); //age를 기준으로 정렬

        for(Member member : memberList){
            System.out.println(member.getAge()+ " " + member.getName());
        }

    }
}
