package lesson02;

public class Ex15_Continue {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; //짝수인 경우 넘어감
            }
            System.out.println("홀수:" + i);
        }
    }
}
