package 정렬;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<Person> list = new ArrayList<>();

        for(int i=0 ; i< num ; i++) {
            int age = scan.nextInt();
            String name = scan.next();
            list.add(new Person(age ,name));
        }
        Collections.sort(list);
        for (int i = 0; i < num; i++) {
            System.out.println(list.get(i).getAge() + " " + list.get(i).getName());
        }
    }
}

class Person implements Comparable<Person>{
    private int age;
    private String name;

    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }

    public Person(int age , String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age < o.age)
            return -1;
        else if(this.age > o.age)
            return 1;
        else
            return 0;
    }
}


/*
* Comparable 인터페이스를 통해서 객체를 정렬 할 생각을 했다.
*
*
* */