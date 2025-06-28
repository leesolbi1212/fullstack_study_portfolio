package lesson03;
class Parent {
    public Parent(String msg) {
        System.out.println("부모 생성자 :" + msg);
    }
}

class Child extends Parent {
    public Child() {
        super("apple"); //부모에 넣어주는 값
        System.out.println("자식 생성자");
    }
}
public class Ex06_Main {
    public static void main(String[] args) {
        Child child = new Child();
    }
}
