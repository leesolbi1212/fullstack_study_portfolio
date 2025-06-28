package lesson08;



public class Ex08_Main {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("익명 Thread 클래스 실행!");
            }
        };
        t1.start();
    }
}
