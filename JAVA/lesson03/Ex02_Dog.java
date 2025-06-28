package lesson03;

public class Ex02_Dog {
    String name; //이름을 저장하려고 함
    int age; // 나이를 저장하려고 함

    public void bark() {
        System.out.println(name + "가 멍멍 짖습니다");
    }

    public void introduce() {
        System.out.println("안녕하세요! 제 이름은 " + name + "이고, 나이는" + age + "살 입니다");
    }
}
