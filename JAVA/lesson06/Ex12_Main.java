package lesson06;
/*
*   < 제네릭 타입 문자 >
*   T : Type (주로 객체 타입)
*   E : Element (컬렉션 요소 타입)
*   K : Key (맵의 키 타입)
*   V : Value (맵의 값 타입)
*   U : 두 번째, 보조 타입(보통 T 다음에 나옴)
 */
// 매개변수 2개짜리 제네릭
class Person<T, U> {
    private T name;
    private U age;
    public Person(T name, U age) {
        this.name = name;
        this.age = age;
    }
    public void printInfo() {
        System.out.println("이름 : " + name + " 나이 : " + age);
    }
}

public class Ex12_Main {
    public static void main(String[] args) {
        Person<String, Integer> p1 = new Person<>("김사과", 20);
        p1.printInfo();
        Person<String, Double> p2 = new Person<>("김사과", 25.5);
        p2.printInfo();
    }
}
