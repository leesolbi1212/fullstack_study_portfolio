package lesson08;

class Ex09_PrintTask implements Runnable {
    private String message;

    public Ex09_PrintTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(message + " - " + (i + 1)); //5바퀴 돌기~
        }
    }
}

public class Ex09_Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Ex09_PrintTask("김사과"));
        Thread t2 = new Thread(new Ex09_PrintTask("반하나"));
        Thread t3 = new Thread(new Ex09_PrintTask("오렌지"));
        t1.start();
        t2.start();
        t3.start();
        // 병렬로 일을 시작하게 됨.순서대로 진행되지 않음 (동기식이 아님).
        /*
        오렌지 - 1
        김사과 - 1
        김사과 - 2
        반하나 - 1
        김사과 - 3
        오렌지 - 2
        오렌지 - 3
        반하나 - 2
        반하나 - 3
        */
    }
}
