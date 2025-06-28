package lesson06;

class Printer {
    public <T> void print(T item) {
        System.out.println("출력 " + item);
    } // item에 넣는 자료에 타입이 아무거나 다 들어갈 수 있다.
}

public class Ex13_Main {
    public static void main(String[] args) {
        Printer printer = new Printer(); // 객체 만들기
        printer.print("안녕");   // 문자
        printer.print(1234567890); // 정수
        printer.print(3.14); // 실수
        printer.print(true); // Boolean
    }
}
