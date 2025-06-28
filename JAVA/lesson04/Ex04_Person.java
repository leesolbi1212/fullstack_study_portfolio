package lesson04;

public class Ex04_Person {
    public String name = "김사과"; //외부에서도 접근할 수 있는 변수
    private int age = 20; //외부 접근 불가
    protected String hobby = "코딩"; //같은 패키지 + 상속구조
    String job = "개발자"; //default

    public void showInfo() {
        System.out.println("이름:" + name);
        System.out.println("나이:" + age);
        System.out.println("취미:" + hobby);
        System.out.println("직업:" + job);
    }
}
