package lesson08;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex12_Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 하나의 스레드를 만드는 것

        Callable<Integer> task = () -> {
            System.out.println("복잡한 계산 중....");
            Thread.sleep(2000);
            return 42; //원래 run에서는 return을 할 수 없지만 Callable을 사용하면 할 수 있다.
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("메인 스레드는 다른 작업 중 ....");
        Integer result = future.get(); // 작업이 완벽하게 끝날 때 까지 기다려줌.
        System.out.println("계산 결과 : " + result);
        executor.shutdown();
    }
}
