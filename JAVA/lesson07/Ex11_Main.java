package lesson07;

interface Ex11_ButtonClickListener {
    void onClick();
}

public class Ex11_Main {
    public static void main(String[] args) {
        Ex11_ButtonClickListener listener = new Ex11_ButtonClickListener() {
            @Override
            public void onClick() {
                System.out.println("버튼이 클릭되었습니다");
            }
        };
        listener.onClick();
    }
}
