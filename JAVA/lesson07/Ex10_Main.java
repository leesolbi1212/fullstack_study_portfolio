package lesson07;

abstract class Ex10_Animal {
    public abstract void speak();

}

public class Ex10_Main {
    public static void main(String[] args) {
        // 익명 객체 생성
        // 클래스 이름 없이 바로 구현 및 인스턴스 생성
        Ex10_Animal tiger = new Ex10_Animal() {
            // 객체를 만들면서 오버라이딩 시키는 것.
            @Override
            public void speak() {
                System.out.println("어흥 나는 호랭");
            }
        };

        Ex10_Animal dog = new Ex10_Animal() {
            @Override
            public void speak() {
                System.out.println("멍멍 나는 댕댕");
            }
        };

        tiger.speak();
        dog.speak();
    }
}
