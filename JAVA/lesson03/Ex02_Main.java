package lesson03;

public class Ex02_Main {
    public static void main(String[] args) {
        // Ex02_Dog 를 불러 쓸 겨
        Ex02_Dog dog1 = new Ex02_Dog(); // 객체 생성
        dog1.name = "루시";
        dog1.age = 18;
        dog1.introduce();
        dog1.bark();

        // 다른 객체 만들기
        Ex02_Dog dog2 = new Ex02_Dog();
        dog2.name = "뽀미";
        dog2.age = 8;
        dog2.introduce();
        dog2.bark();

    }
}
