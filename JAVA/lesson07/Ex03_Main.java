package lesson07;

import java.util.TreeSet;

class Student implements Comparable<Student> {
    String name;
    int score;
    // 생성자 만들기
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
        // 정수 래핑클래스, compare라는 메서드가 있음. score 값에 저장되어있는 값과 지금 객체로 들어온 score값을 비교해서 오름차순으로 정렬해달라. 내림차순 하고 싶으면 this와 o의 순서를 바꿔주면 됨.
        // 점수가 중복일 경우에는 하나가 삭제됨.
        // return 값은? 비교된 값이 나오게 되는데, a < b = -1, a == b = 0, a > b = 1
    }

    @Override
    public String toString() {
        return name + "(" + score + "점)";
    }
}



public class Ex03_Main {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        // <> 안에 들어갈 수 있는 건 레퍼 클래스 등을 넣었는데, Student객체를 넣으면 트리셋에 쌓일 것임. Student에는 이름,점수 2개가 들어있음 그렇다면 뭐로 정렬을 시킬까?
        students.add(new Student("김사과", 90));
        students.add(new Student("반하나", 85));
        students.add(new Student("오렌지", 95));
        students.add(new Student("이메론", 92));
        students.add(new Student("배애리", 82));
        // 어떻게 들어가있는지 확인해보자
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }

}
