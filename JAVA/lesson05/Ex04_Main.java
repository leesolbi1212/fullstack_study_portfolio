package lesson05;

// 설계도 같은 역할
interface Ex04_Animal {
    int num = 10; // = >> public static final int num = 10
    void sound();
    void move();
}
// 생성 -> 구현
class Ex04_Dog implements Ex04_Animal {
    @Override
    public void sound() {
        System.out.println("으을르르를ㄹ르컹컹ㅇ렄ㄱ으을ㅇ러");
    }

    @Override
    public void move() {
        System.out.println("개가 네 발로 뜁니다");
    }
}

class Ex04_Bird implements Ex04_Animal {
    @Override
    public void sound() {
        System.out.println("뺙뺙");
    }

    @Override
    public void move() {
        System.out.println("새가 날아갑니다");

    }
}
public class Ex04_Main {
    public static void main(String[] args) {
        Ex04_Animal dog = new Ex04_Dog();
        Ex04_Animal bird = new Ex04_Bird();
        dog.sound();
        bird.sound();
        dog.move();
        bird.move();
    }
}
