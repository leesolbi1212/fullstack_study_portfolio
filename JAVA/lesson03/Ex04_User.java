package lesson03;

public class Ex04_User {
    String name;
    int age;

    // 매개변수가 없는 생성자 먼저 만들기
    public Ex04_User() {
        this("이름없음", 0);
        System.out.println("기본 생성자 호출됨");
    }

    public Ex04_User(String name) {
        this(name,0);
        System.out.println("이름만 받는 생성자 호출됨");
    }

    public Ex04_User(String name, int age) {
        System.out.println("이름과 나이를 받는 생성자 호출됨");
        if(age < 0) {
            System.out.println("나이는 음수가 될 수 없습니다");
            this.age = 0; //이 클래스에 변수로 선언해놓은 age에 0을 세팅
        } else {
            this.age = age;
        }
        if(name == null || name.trim().isEmpty()) {
        // 함수형 프로그래밍 : 앞 뒤 공백 날리고, 값 사용하고
            this.name = "이름없음";
        } else {
        this.name = name;}
    }

    public void introduce() {
        System.out.println("안녕하세요. 제 이름은 " + name + "이고, 나이는 " + age + " 살 입니다.");
    }
    // 같은 이름의 메서드를 안에 파라미터만 다르게하면 여러 개 만들 수 있다 (오버로딩)
    public static void main(String[] args) {
        Ex04_User u1 = new Ex04_User();
        Ex04_User u2 = new Ex04_User("김사과");
        Ex04_User u3 = new Ex04_User("반하나", 25);

        u1.introduce();
        u2.introduce();
        u3.introduce();
        // String의 기본값은 null, int의 기본값은 0이다.
    }
}
