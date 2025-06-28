package lesson04;

abstract class Vehicle {
    abstract void move(); // 구현은 하지 않음 (추상 메서드)

    public void start() {
        System.out.println("시동을 겁니다.");
    }
}

class Car extends Vehicle {
    @Override // 꼭 오버라이딩 해서 사용해야함.
    void move() {
        System.out.println("도로를 달립니다.");
    }
}

public class Ex07_Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.move();

    }
}
