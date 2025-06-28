package lesson08;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Ex14_Order {
    private final int orderId;
    public Ex14_Order(int orderId) {
        this.orderId = orderId; //id 번호를 받아다가 저장해 줄 생성자
    }
    public int getOrderId() {
        return orderId;
    }
}

//Callable을 class로 구현해서 사용하기 (Runnable을 이용하면 return하지 못하기 때문)
class OrderProcessor implements Callable<String> {
    private final Ex14_Order order;
    private final String workerName;
    private static final Random random = new Random();

    private  static final Map<String, int[] > workerSpeedMap = Map.of(
            "김사과",new int[] {1000,2000}, //숫자가 작을수록 빨라용~
            "반하나",new int[] {2000,3000},
            "오렌지",new int[] {3000,4000}
    );
    private static final AtomicInteger totalProcessed = new AtomicInteger(0); //고전적인 방법으로 멀티스레스방법에서 값을 수정할 때 동시다발적으로 일어날 수 있으니까 싱크로나이즈를 썼었음. 근데 AtomicInteger은 멀티 스레드일 때 값을 알아서 충돌나지 않게 해준다. 값을 더하거나 빼거나 연산을 할 때 이 객체에 있는 값은 멀티스레드 환경에서 충돌나지 않음
    private static final AtomicInteger processed = new AtomicInteger(0);
    private static final Map<String, Integer> workerStats = new ConcurrentHashMap<>();
    //맵을 쓰는데 스레드에 안정된 클래스

    public OrderProcessor(Ex14_Order order, String workerName) {
        this.order = order;
        this.workerName = workerName;
    }

    @Override
    public String call() throws Exception {
        int[] speedRange = workerSpeedMap.get(workerName);
        int prepTime = random.nextInt(speedRange[1] -  speedRange[0] + 1) + speedRange[0];
        Thread.sleep(prepTime);
        // 주문 1건이 처리되었으니, 전체 주문 수를 1 증가시켜라 
        totalProcessed.incrementAndGet();
        // workerName : 아르바이트생 이름 
        // 1 : 처리한 주문 수
        // 알바생 이름이 Map에 없으면 (workerName, 1)로 추가 
        // 이미 있다면 ("김사과", 기존값+1)로 업데이트 해줘! (Integer::sum)
        workerStats.merge(workerName,1, Integer::sum );
        return workerName + " - 주문 " + order.getOrderId() + " 번 완료 (소요시간 : " + prepTime + "ms)";
    }
    
    public static int getTotalProcessed() {
        return totalProcessed.get();
    }
    public static void printStats() {
        System.out.println("점원별 처리 주문 수");
        workerStats.forEach((name,count)-> System.out.println(name + " : " + count + "건"));
    }
}

public class Ex14_Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int totalOrders = 10; //전체 주문이 10개
        List<String> workers = List.of("김사과", "반하나", "오렌지");
        ExecutorService executor = Executors.newFixedThreadPool(workers.size());
        List<Future<String>> futures = new ArrayList<>(); //리턴 받을 Future을 만든다! 배열에 저장

        for (int i = 0; i < totalOrders; i++) {
            String worker = workers.get(i % workers.size()); //리턴된 걸 가져오는데, 사이즈만큼 나눌 것.
            Ex14_Order order = new Ex14_Order(i);
            futures.add(executor.submit(new OrderProcessor(order, worker)));
            // futures에 결과값들이 쌓일 것
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        
        executor.shutdown();
        OrderProcessor.printStats();
        System.out.println("총 주문 처리 수 : " + OrderProcessor.getTotalProcessed() + "건");

    }
}
