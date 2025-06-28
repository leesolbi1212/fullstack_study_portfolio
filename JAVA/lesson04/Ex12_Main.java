package lesson04;

class Singleton {
    private static final Singleton instance = new Singleton();
    // 자기 자신의 객체를 만들어서 변수(instance)로 넣는데, (static) 메모리에 바로 올라가고, 수정 못하고, private함.
    // 시작하자마자 객체가 만들어서 올라가 있음
    private Singleton() {
        // 생성자를 만들기
        System.out.println("싱글톤 객체 생성됨"); //내부에서 생성하니까 생성자가 private이어도 상관 없음
    }

    public static Singleton getInstance() {
        // 외부에서 쓸 수 있음
        return instance; // 내부에서 만든 객체를 리턴
    }

    public void printMessage() {
        System.out.println("싱글톤 패턴으로 실행 중");
    }
}
public class Ex12_Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance(); // DB를 만들었다면 쓸 수 있는 것
        Singleton s2 = Singleton.getInstance(); // 별도의 객체를 만드는 게 아니라, 같은 객체를 가지고 공유해서 쓰는 것
        s1.printMessage();
        s2.printMessage();
        System.out.println(s1 == s2);
        // 미리 만들어져있는 객체를 getInstance로 리턴만해서 사용하는 거라서 같은 주소를 참조하게 됨.
    }
}
