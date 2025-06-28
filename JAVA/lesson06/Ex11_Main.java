package lesson06;

class Box<T> {
    // 타입이 어떤 게 오더라도 자동으로 변환됨
    private T item;
    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}

public class Ex11_Main {
    public static void main(String[] args) {
        Box<String> stringBoxbox = new Box<>(); //<T>가 String이 된다.
        stringBoxbox.setItem("바나나");
        String fruit = (stringBoxbox.getItem());
        System.out.println("과일 " + fruit);

        Box<Integer> intBox = new Box<>();
        intBox.setItem(10);
        int number = intBox.getItem(); //형 변환 없이 꺼냄
        System.out.println("숫자 " + number);
    }
}
