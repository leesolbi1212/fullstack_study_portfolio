package lesson03;

class Animal {
    String name;
    public Animal(String name) {
        this.name = name; // 이름을 전달 받고 필드에 저장

    }
    public void eat() {
        System.out.println(name + "냠냠쓰");
    }
    public final void sleep() {
        System.out.println(name + "쿨쿨쓰");
    }
    public void speak() {
        System.out.println(name + "나불쓰");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + "멍멍쓰~");
    }
    public void bark() {
        System.out.println("멍멍");
    }
    public void bark(String target) {
        System.out.println(target + "을 보고 멍멍");
    }
    public void bark(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("으르르르왈르을릉ㄹ컹ㅋ엉!컼!!ㅇ르으를ㄹㄹ컼엌엉ㅇ엉!!!");
        }
    }
}

public class Ex08_Main {
    public static void main(String[] args) {
        Dog rucy = new Dog("루시");
        rucy.eat();
        rucy.sleep();
        rucy.speak(); // 부모는 원래 나불쓰, 자식이 멍멍쓰 (출력:멍멍쓰)
        rucy.bark();
        rucy.bark("택배 아저씨");
        rucy.bark(3);
    }
}
