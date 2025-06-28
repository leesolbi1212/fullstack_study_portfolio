package lesson03;

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public void greet() {
        System.out.println("안녕하세요, 저는" + name + "입니다.");
    }
}
class Student extends Person {
    String school;
    public Student(String name, String school) {
        super(name); //부모한테 채워주기
        this.school = school; //자식은 나한테 채워주면 됨
    }

    @Override
    public void greet() {
        super.greet(); // 이걸 추가해줘야 부모 것도 출력됨
        System.out.println("학교는 " + school + "입니다.");
        // 오버라이딩 하면 자식이 우선 출력됨. super을 하지 않으면 자식만 출력
    }
}

public class Ex07_Main {
    public static void main(String[] args) {
        Person person = new Person("김사과"); //부모 객체
        person.greet(); // 부모에 있는 메서드 잘 쓸 수 있음
        Student student = new Student("반하나", "코리아");
        student.greet();
    }
}
