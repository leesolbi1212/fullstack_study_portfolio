package lesson06;

public class Ex05_Main {
    // 매개변수가 오지 않았을 때
    public static double calculateSqrt(int number) throws IllegalArgumentException {
        if(number < 0) {
            throw new IllegalArgumentException("음수는 제곱근을 계산할 수 없습니다.");
        }
        return Math.sqrt(number);
    }
    public static void main(String[] args) {
        try {
            double result = calculateSqrt(-9);
            System.out.println("결과 :" + result);
        } catch (IllegalArgumentException e) {
            System.out.println("예외발생 :"  + e.getMessage());

            //try/catch를 지웠을 경우에는 error 발생하고 프로그램이 정상적으로 종료되지 않음.
        }
    }
}
