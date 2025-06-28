package lesson04;

class Account {
    private int balance = 0; //외부에서 접근 안됨

    public void deposit(int amount) {
        if (amount > 0) balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class Ex05_Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000);
        // account.balance = 10000 //외부에서 접근 안되게 막아놨기 때문에 안됨(은닉성)
        System.out.println("잔액 : " + account.getBalance());
        // getBalance를 이용해서 읽기만 할 수 있음
    }
}
