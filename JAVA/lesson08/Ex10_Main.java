package lesson08;

class Ex10_Counter {
    private int count = 0;
    public synchronized void increment() { //기다렸다가 나오게 됨 최종 카운트 20000
        count++;
    }
    public int getCount() {
        return count;
    }
}

public class Ex10_Main {
    public static void main(String[] args) throws InterruptedException {
        Ex10_Counter counter = new Ex10_Counter();
        // 할 일 1
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };
        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        th1.start();
        th2.start();
        th1.join(); // main이 th1이 끝날 때까지 기다려줌.
        th2.join();
        System.out.println("최종 카운트" + counter.getCount());
        // 카운터에 있는 클래스가 1씩 더해져서 만 번 돌게 되어있는데,,,최종 카운트15039 라고 나옴. 같이 돌 다 보니까 안되는 겨
    }
}
