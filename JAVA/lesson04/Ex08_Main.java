package lesson04;

class Ex08_Car {
    static int count = 0;
    public Ex08_Car() {
        count++;
    }
}

public class Ex08_Main {
    public static void main(String[] args) {
        // 객체 생성을 하는 데 변수에 담지 않았어요! 일단 생성만 해봄
        new Ex08_Car();
        new Ex08_Car();
        new Ex08_Car();
        System.out.println("총 생성된 자동차 수 : " + Ex08_Car.count);
        // 객체를 생성하지 않고 클래스의 이름으로 직접 접근함
    }
}
