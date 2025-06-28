package lesson05;

// 인터페이스란?
// 같이 작업하는 사람들에게 이런 게 있었으면 좋겠어! 라고 요청하는 명세서 같은 것

// 한 파일에 몰아넣었기 때문에 public을 지움

interface Cleaner {
    void clean(); //각각 움직이나 행동을 구현할 수 있게 만들어놓음
}
interface Cooker {
    void cook();
}

interface Singer {
    void sing();
}

interface Dancer {
    void dance();
}

// 추상메서드 : 객체를 생성할 수 없음. 다른 클래스로부터 상속을 받은 다음에 사용해야함.
abstract class Robot{
    String modelName;

    public Robot(String modelName) {
        this.modelName = modelName; //모델이름을 받아서 사용할 수 있게끔
    }
    public void identify() {
        System.out.println("안녕하세요 저는 " + modelName + "로봇입니다.");
    }
}

//로봇을 상속받는 클래스. 인터페이스를 모두 구현하겠다! 라는 것
class MultiRobot extends Robot implements Cleaner, Cooker, Singer, Dancer {
    // 빈 생성자가 아니라 이름을 받아야하기 때문에 오버라이딩 해야함.
    public MultiRobot(String modelName) {
        super(modelName); // 부모에게 값을 전달하기 위함
    }

    @Override
    public void clean() {
        System.out.println("["+modelName+"] 청소를 시작합니다.");
    };

    @Override
    public void cook() {
        System.out.println("["+modelName+"] 요리를 시작합니다.");

    }

    @Override
    public void dance() {
        System.out.println("["+modelName+"] 멋지게 춤을춥니다.");

    }

    @Override
    public void sing() {
        System.out.println("["+modelName+"] 노래를 합니다.");

    }
}

public class Ex05_Main {
    // Cleaner를 포함하는 객체를 만들 수 있게 된다. 다른 인터페이스는 사용하지 못함.
    public static void performFunction(Cleaner cleaner) {
        cleaner.clean();
    }

    public static void performFunction(Cooker cooker) {
        cooker.cook();
    }

    public static void performFunction(Singer singer) {
        singer.sing();
    }

    public static void performFunction(Dancer dancer) {
       dancer.dance();
    }


    public static void main(String[] args) {
        // 로봇이라는 객체를 생성해서 각각을 사용할 순 있지만 다형성으로 이용하는 방법을 써보자
        MultiRobot robot = new MultiRobot("Robo-X");
        robot.identify();
        robot.clean();
        robot.cook();
        robot.dance();
        robot.sing();

        //로봇은 Cleaner로 바뀌게 된다 (업캐스팅)
        //강제 형변환을 시켜야 어떤 모양으로 바꿀지를 알 수 있음
        performFunction((Cleaner) robot);
        performFunction((Cooker) robot);
        performFunction((Singer) robot);
        performFunction((Dancer) robot);
        }
    }




