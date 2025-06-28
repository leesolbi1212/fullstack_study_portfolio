package lesson07;

import java.util.Comparator;
import java.util.TreeSet;

class Ex04_Student  {
    String name;
    int score;
    // 생성자 만들기
    public Ex04_Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "(" + score + "점)";
    }
}

public class Ex04_MAin {
    public static void main(String[] args) {
        Comparator<Ex04_Student> comparator= (a,b) -> b.name.compareTo(a.name);
        TreeSet<Ex04_Student> students = new TreeSet<>(comparator);
        // <> 안에 들어갈 수 있는 건 레퍼 클래스 등을 넣었는데, Student객체를 넣으면 트리셋에 쌓일 것임. Student에는 이름,점수 2개가 들어있음 그렇다면 뭐로 정렬을 시킬까?
        students.add(new Ex04_Student("김사과", 90));
        students.add(new Ex04_Student("반하나", 85));
        students.add(new Ex04_Student("오렌지", 95));
        students.add(new Ex04_Student("이메론", 92));
        students.add(new Ex04_Student("배애리", 85));
        // 어떻게 들어가있는지 확인해보자
        for (Ex04_Student student : students) {
            System.out.println("- " + student);
        }
    }
}
