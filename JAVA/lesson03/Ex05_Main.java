package lesson03;

class Ex05_Animal {
    public void eat() {
        System.out.println("냠냠쓰");
    }
} //Animal은 eat이라는 메서드를 가지고 있다.

class Ex05_Dog extends Ex05_Animal {
    public void bark() {
        System.out.println("왕왕 짖는다.");
    }
}

public class Ex05_Main {
    public static void main(String[] args) {
        Ex05_Dog dog = new Ex05_Dog(); //객체 생성
        dog.eat(); //아무것도 안 만들었지만 기능도 상속됨
        dog.bark();
    }
}
