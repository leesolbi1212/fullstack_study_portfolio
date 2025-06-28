package lesson03;

public class Ex01_Method {
    public void printHello() {
        System.out.println("안녕하세요");
    }

    public void printName(String name) {
        System.out.println("이름 : " + name);
    }

    // 매개변수 x, 리턴 값 o
    public int getRandomNumber() {
        return (int) (Math.random() * 100);
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int sumAll(int... numbers) {
        int sum = 0;
        for (int n: numbers) {
            sum += n;
        }
        return sum;
    }

    // 시작점을 만들어 줄게요! (main 입력)
    public static void main(String[] args) {
        // 클래스 명 써주고, 변수명 . 으로 접근하면 된다.
        Ex01_Method ex01_Method = new Ex01_Method();
        ex01_Method.printHello();
        ex01_Method.printName("김사과");

        int rand  = ex01_Method.getRandomNumber();
        System.out.println("랜덤 숫자 :" + rand);

        int result = ex01_Method.multiply(4,5);
        System.out.println("곱셈 결과 :" + result);

        int total = ex01_Method.sumAll(1,2,3,4,5);
        // 배열로 받게 되고, 갯수만큼 for문을 돌면서 더해줌
        System.out.println("덧셈 결과 :" + total);
        System.out.println("합(빈 값으로 호출) :" + ex01_Method.sumAll());
    }
}
