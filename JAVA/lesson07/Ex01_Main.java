package lesson07;

import java.util.HashSet;

public class Ex01_Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>(); // 고정된 길이를 갖는다. hash 알고리즘을 사용한다. set 중복되지 않음
        set.add("김사과");
        set.add("반하나");
        set.add("오렌지");
        set.add("이메론");
        set.add("배애리");
        // 중복 데이터 : 추가되지 않음 : [반하나, 이메론, 김사과, 오렌지, 배애리]
        set.add("김사과");
        set.add("배애리");

        System.out.println(set);
        // [반하나, 이메론, 김사과, 오렌지, 배애리] : 순서가 없는 모습

        // 내부적으로 순서가 없더라도 반복문은 돌릴 수 있는 자료구조임
        System.out.println("출석한 학생 명단 ");
        for(String name : set) {
            System.out.println("- " + name);
        }
        // 출석한 학생 명단 
        //- 반하나
        //- 이메론
        //- 김사과
        //- 오렌지
        //- 배애리

        // 데이터 있는 지 찾아보기 : contains
        System.out.println("오렌지 출석 여부 : "+ set.contains("오렌지")); //오렌지 출석 여부 : true
        System.out.println("박수박 출석 여부 : "+ set.contains("박수박")); //박수박 출석 여부 : false

        // 삭제
        set.remove("이메론");
        for(String name : set) {
            System.out.println("- " + name);
        }
        //- 반하나
        //- 김사과
        //- 오렌지
        //- 배애리

        // 자바스크립트, json은 key : value가 있다. set은 순서가 없기 때문에 인덱스도 없고, key도 없다. 그래서 value를 꺼낼 방법이 없어서 value 자체로 찾아낸다. (오렌지, 박수박 직접 입력)
    }
}
