package lesson04;

class calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}

public class Ex09_Main {
    public static void main(String[] args) {
        int result = calculator.add(10, 20);
        System.out.println("결과 : " + result);
    }
}
