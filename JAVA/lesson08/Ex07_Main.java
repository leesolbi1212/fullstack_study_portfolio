package lesson08;

class Ex07_MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable 스레드 실행 중! - " + Thread.currentThread().getName());
    }
}

public class Ex07_Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Ex07_MyRunnable());
        t1.start();
    }
}
