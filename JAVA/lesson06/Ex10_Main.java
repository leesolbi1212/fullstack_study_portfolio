package lesson06;

class ObjectBox {
    // 변수는 직접 값을 접근하면 안돼(은닉성) get/set으로 값을 받아서 처리
    private Object item;
    public void set(Object item) {
        this.item = item;
    }
    public Object get() {
        return item;
    }

}

public class Ex10_Main {
    public static void main(String[] args) {
        ObjectBox box = new ObjectBox();
        // 여기에 데이터를 저장하려고 해 -> set을 넣을 건데, 만약에 문자/숫자/더블형 등등 여러가지 타입을 저장해야한다면 여러 개 만들어야함. 근데 Object로 만들었기 때문에 일단 넣을 순 있음
        box.set("사과"); //다시 값을 리턴해주려면 get으로 해줘야되는데
        Object obj = box.get(); //자식 형태로 가져올 땐 다운캐스팅 해줘야함.
        String fruit = (String) obj; //강제 형변환 해줘야함.
        System.out.println("과일" + fruit);
        // 이렇게 해도 되긴 하는데,, 작업은 나 혼자 하는 게 아니죠?
        box.set(123);
        obj = box.get();
//        String fruit = (String) obj -> 잘못된 형 변환 시 에러 발생
    }
}
