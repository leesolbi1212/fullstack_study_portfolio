package lesson04;

class Ex06_Animal {
    public void speak() {
        System.out.println("동물이 소리를 냅니다");
    }
}

class Ex06_Cat extends Ex06_Animal {
    @Override //상속 받은 걸 오버라이딩 시킴
    public void speak() {
        System.out.println("먀앍!");
    }
}
class Ex06_Dog extends Ex06_Animal {
    @Override //상속 받은 걸 오버라이딩 시킴
    public void speak() {
        System.out.println("멍멍!");
    }
}

public class Ex06_Main {
    public static void main(String[] args) {
        Ex06_Animal a1 = new Ex06_Cat(); // 업 캐스팅 해서 객체를 만듦 (추가로 부모에 없는 메서드는 사용할 수 없지만 오버라이딩 됨)
        Ex06_Animal a2 = new Ex06_Dog();
        a1.speak();
        a2.speak(); // 다형성
    }
}
