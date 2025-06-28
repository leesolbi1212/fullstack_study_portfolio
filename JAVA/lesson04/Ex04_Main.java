package lesson04;


public class Ex04_Main {
    public static void main(String[] args) {
        Ex04_Person person = new Ex04_Person();
        System.out.println(person.name); //public
        // System.out.println(person.age); // private이기 때문에 못 씀
        System.out.println(person.hobby); // protected이기 때문에 같은 패키지라서 접근 가능
        System.out.println(person.job); // 같은 패키지 내에서 사용 가능
    }
}
