package lesson03;

public class Ex03_Person {
    String name;
    int age;

    public Ex03_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Ex03_Main {
    public static void main(String[] args) {
        Ex03_Person person = new Ex03_Person("김사과", 20);
        System.out.println(person.name + ", " + person.age);
    }
}