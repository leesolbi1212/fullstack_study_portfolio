package lesson01;

public class Ex03_TypeCasting {
    public static void main(String[] args) {
        int score = 90;
        double average = score;
        System.out.println("자동 형 변환 결과 :" + average);

        double pi = 3.14159;
        int truncatedPi = (int) pi;
        System.out.println("강제 형 변환 결과 : " + truncatedPi);

        char grade = 'A';
        int gradeCode = grade;
        System.out.println("문자 A의 유니코드 값 : " + gradeCode);
//      문자도 아스키 코드이기 때문에 유니코드 값으로 찍힘

        int code = 66; // 'B'
        char letter = (char) code; // 66이 2바이트에는 넣을 수 있긴 함
        System.out.println("유니코드 66에 해당하는 문자는 : " + letter);
    }
}
