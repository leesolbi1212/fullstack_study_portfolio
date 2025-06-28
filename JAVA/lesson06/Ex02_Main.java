package lesson06;

public class Ex02_Main {
    public static void main(String[] args) {
        int[]  numbers = {1,2,3};
        try {
            System.out.println(numbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 범위를 벗어났습니다. " + e);
            // 객체를 그대로 찍어버리면 toString이 나온다.
            System.out.println("배열 범위 벗어남" + e.getMessage());
        }
    }
}
