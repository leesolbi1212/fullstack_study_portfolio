package lesson04;
class Config {
    static int maxUsers;
    static {
        maxUsers = 100;
        System.out.println("Config 클래스가 로딩되면서 초기화 됨");
        // 값을 뭔가 세팅하고 싶은 게 있으면 여기에 넣고 시작하면 됨.
    }
}
public class Ex10_Main {
    public static void main(String[] args) {
        System.out.println("최대 사용자 수 : " + Config.maxUsers );
        // 처음에는 아무 값도 없고, static 블록이 실행되면 100을 담게 되어있다.
        // 객체가 만들어지기 전에 실행됨.
    }
}
