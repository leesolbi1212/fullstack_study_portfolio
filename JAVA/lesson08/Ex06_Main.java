package lesson08;

class Ex06_MyThread extends Thread {
    @Override // 일하는 역할
    public void run() {
        // 일 하는 작업 단위
        System.out.println("스레드 실행 중! - " + Thread.currentThread().getName());
    }
}

public class Ex06_Main {
    public static void main(String[] args) {
       // 프로그램을 실행하면 main부터 실행하게 돼요! 이 작업 한 개가 한 개의 스레드임!
       // 이제 여러 일을 할 수 있게 (동시다발적으로) 만들거예요
        Ex06_MyThread t1 = new Ex06_MyThread(); //위에 만든 클래스를 객체로 만들기
        t1.start(); // 하나의 일이 동시에 시작됨. run이 아니라 start로 실행시켜줘야함.


    }
}
