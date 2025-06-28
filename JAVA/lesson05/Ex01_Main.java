package lesson05;

abstract class Ex01_Animal {
    String name;

    public Ex01_Animal(String name) {
        this.name = name;// 생성자에서 보내온 값을 저장하기
    }
    abstract void sound(); //반환형은 무조건 void는 아님, sound를 추상 메서드로 만든 것

    void sleep() {
        System.out.println(name + "이가 잠을 잡니다");
    }
}
// 부모는 객체 생성할 수 없다. abstract 클래스이기 때문

class Dog extends Ex01_Animal {
    // 오버라이딩과 함께 생성자도 만들어줘야함.
    public Dog(String name) {
        super(name); // 부모쪽으로 내가 전달 받은 name 값을 넘겨주기
    }
    // 오버라이딩 하기
    @Override
    void sound() {
        // 메서드 재정의가 아니라 메서드 구현으로 들어가서 클릭해야함.
        System.out.println(name + "이(가) 멍멍 짖습니다");
    }

    void eat() {
        System.out.println(name + "이(가) 먹습니다");
    }
}

public class Ex01_Main {
    public static void main(String[] args) {
//        Animal animal = new Dog("동물"); 추상 클래스는 객체 생성을 할 수 없다
        Dog dog = new Dog("루시");
        dog.sound(); // 자식 클래스에서 만든 사운드
        dog.sleep(); // 부모 클래스에서 만든 사운드
        dog.eat(); // 자식 클래스에서 만든 사운드

        // 다형성 적용해보기 : 부모에 의해서 여러 자식 클래스로 만들어지는 것 (업 캐스팅)

        Ex01_Animal dog2 = new Dog("루시");
        // 오버라이딩 한 건 그대로 쓸 수 있고, 자식이 갖고 있는 eat은 쓰지 못함
        dog2.sound(); // 오버라이딩 한 건 쓸 수 있음 (자식)
        dog2.sleep();
//        dog.eat(); 이건 자식만 쓸 수 있기 때문에 못 씀 (오버라이딩 안함)
    }
}
