package lesson08;

import java.util.List;
import java.util.concurrent.*;

public class Ex13_Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 3개의 Callable 작업 생성
        List<Callable<String>> tasks = List.of(
                () -> { Thread.sleep(500); return "사과"; }, // 이게 하나의 스레드임
                () -> { Thread.sleep(300); return "바나나"; },
                () -> { Thread.sleep(700); return "포도"; }
        );

        // 모든 작업이 끝날 때까지 대기
        List<Future<String>> futures = executor.invokeAll(tasks);

        // 결과 출력 (리턴 받아서 출력)
        for (Future<String> f : futures) {
            try {
                System.out.println("결과: " + f.get()); //get으로 꺼내면 됨
            } catch (ExecutionException e) {
                System.out.println("작업 중 예외 발생: " + e.getCause()); //get으로 꺼내면 됨
            }
        }

        executor.shutdown();
    }
}

