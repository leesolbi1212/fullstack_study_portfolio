package lesson04;

    class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

        @Override
        public String toString() {
            return "이름:"+name+" 나이:"+age;
        }

        @Override
        public boolean equals(Object obj) {
            if(this ==obj) return true;
            // 현재 내가 가지고 있는 객체와 전달받은 객체가 같니? this는 equals를 쓴 자기 자신
            if(obj == null || getClass() != obj.getClass()) return false;
            // obj가 null이거나 클래스가 다르다면 false (걸러낼 것들 다 걸러내는 작업)
            Person other = (Person)obj; // 강제 형 변환
            return this.name.equals(other.name) && this.age == other.age;

        }
    }

public class Ex01_Main {
    public static void main(String[] args) {
        Person p1 = new Person("김사과", 20);
//        System.out.println(p1.toString());
//        System.out.println(p1);
        Person p2 = new Person("반하나", 25);
        Person p3 = new Person("김사과", 20);
        // 저장하는 값이 같더라도 메모리 주소가 다름

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        // equals는 메모리 주소가 같은지 비교하는 것
    }
}