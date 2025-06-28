package lesson04;

class Animal {
    public void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍!");
    }

    public void wagTail() {
        System.out.println("꼬리를 흔듭니다.");
    }
}

public class Ex02_Main {
    public static void main(String[] args) {
        Dog dog = new Dog();   // Dog 객체 생성
        dog.sound();
        dog.wagTail();
        Animal animal = dog;             // 업캐스팅 부모의 형태로 바꿈
        animal.sound();                  // 멍멍! (오버라이딩된 메서드 호출)
        // animal.wagTail();             // 컴파일 에러! Animal 타입에는 없음
        // 형태 자체는 부모 형태이기 때문에 업캐스팅이 안됨
        Dog dog2 = (Dog) animal; // 다운캐스팅으로 다시 돌려놓은 것
        dog2.wagTail();
        dog2. sound();
    }
}