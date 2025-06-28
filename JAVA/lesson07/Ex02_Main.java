package lesson07;

import java.util.TreeSet;

public class Ex02_Main {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<String>();
        // 저장과 삭제는 느릴 수 있지만, 검색이 빠르다. 정렬도 함.
        set.add("김사과");
        set.add("반하나");
        set.add("오렌지");
        set.add("이메론");
        set.add("배애리");

        set.add("김사과");
        System.out.println(set);
        // [김사과, 반하나, 배애리, 오렌지, 이메론] : 중복데이터를 넣었지만, 추가 X , 오름차순으로 정렬
        // 정렬되는 상황? add 될 때 정렬을 하고 들어감 (그래서 insert 될 때 느린 것)

        for (String name : set) {
            System.out.println("- " + name);
            //- 김사과
            //- 반하나
            //- 배애리
            //- 오렌지
            //- 이메론
        }
        // 앞에 오는 값 : lower, 뒤에오는 값 : higher
        System.out.println("오렌지보다 앞에 있는 이름 찾기 : " + set.lower("오렌지")); // 배애리
        System.out.println("오렌지보다 뒤에 있는 이름 찾기 : " + set.higher("오렌지")); // 이메론
        // key:value가 없기 때문에 value 자체로 찾아야 함

        // 만약 내림차순을 하고 싶다면? Comparable을 오버라이딩 하면 됨
        // Comparable이란?

    }
}
