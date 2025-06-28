package lesson01;

public class Ex02_DataType {
    public static void main(String[] args) {
//      main :  jvm이 가장 먼저 자동으로 실행시켜주는 메서드, 함수 역할을 하는 것
        int age = 20; // 정수형
        double height = 160.5; // 실수형
        char grade = 'A'; // 문자형 (한 글자)
        boolean isStudent = true; // 관례상 is로 시작하면 논리형
        String name = "김사과"; // 문자열 (참조형)

        System.out.println("이름:" + name);
        System.out.println("나이:" + age);
        System.out.println("키:" + height);
        System.out.println("학점:" + grade);
        System.out.println("학생여부:" + isStudent);

    }
}
