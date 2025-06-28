package lesson08;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex11_Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("작업" + taskId + "실행 중 (스레드 : " + Thread.currentThread().getName() + ")");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("작업" + taskId + "완료");
                }
            });
        }
        executor.shutdown();
        // 3개가 먼저 나오고 나머지 2개가 뜨게 된다. 스레드 3개를 만들어놨기 때문
        //
    }
}
