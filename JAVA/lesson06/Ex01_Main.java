package lesson06;

public class Ex01_Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("결과" + result);
            // 빨간색 밑줄이 아니기 때문에 문법 에러는 아님. 실행은 됐으나, 숫자 관련한 에러(ArithmeticException)가 발생했기 때문에 예외처리로 묶어줘야함.
        } catch (ArithmeticException e) {
            // e 는 ArithmeticException의 객체이다. getMessage를 제거해도 출력되긴 함.
            System.out.println("예외발생 : " + e.getMessage());
        } finally {
            System.out.println("이 코드는 항상 실행됩니다.");
        }
    }
}
