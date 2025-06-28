package lesson06;

import java.util.LinkedList;

public class Ex15_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("김사과");
        ll.add("반하나");
        ll.add("오렌지");
        //arraylist에서는 인덱스로 저장되지만, ll은 연결된다. 다음 다음 다음

        // 자주 사용하진 않음
        ll.addFirst("이메론"); //가장 처음에 삽입
        System.out.println(ll);

        System.out.println("현재 대기열 : ");
        for (String s : ll) {
            System.out.println("- " + s);
        }

        while(!ll.isEmpty()) {
            String s = ll.removeFirst(); // 제일 처음에 있는 데이터 삭제 후 저장
            System.out.println("결과: " +ll);
            System.out.println("떼어낸 놈: " +s);
        }

        System.out.println("남은 데이터 : " + ll.size());
        // while에서 다 삭제했으니까 없음
    }
}
