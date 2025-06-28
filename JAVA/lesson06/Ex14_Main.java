package lesson06;

import java.util.ArrayList; // 자동으로 import 됨

public class Ex14_Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<String>();
        students.add("김사과"); // 데이터 추가 0
        students.add("반하나"); // 데이터 추가 1
        students.add("오렌지"); // 데이터 추가 2
        // add만 하면 순서대로 추가되는 것
        students.add(1,"이메론"); // 속도가 느려지는 구간
        // 인덱스까지 정해지면 1번에 있던 데이터부터 한 칸씩 밀리게 됨 (속도 저하)
        System.out.println(students);
        // 배열이니까 향상된 for문 사용 가능
        for (String name : students) {
            System.out.println("- " + name); // 갯수만큼 알아서 돌아간다
        }
        String student = students.get(2); //index 2 번을 가져와라
        System.out.println("\n2번 인텍스의 학생 : " + student);

        students.set(2, "채애리"); //2번 값을 바꾸겠다.
        System.out.println("\n수정 후 2번 인텍스의 학생 : " + students.get(2));

        students.remove("이메론");
        System.out.println(students);
        students.remove(0); //인덱스로도 지울 수 있음
        System.out.println(students);

        System.out.println("\n현재 학생 수 : " + students.size()); //갯수 세기
        System.out.println("\n최종 학생 목록 : ");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

    }
}
