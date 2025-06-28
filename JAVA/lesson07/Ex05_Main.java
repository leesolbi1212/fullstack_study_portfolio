package lesson07;

import java.util.HashMap;
import java.util.Map;

public class Ex05_Main {
    public static void main(String[] args) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("김사과", 90);
        scoreMap.put("반하나", 85);
        scoreMap.put("오렌지", 95);
        scoreMap.put("이메론", 88);
        scoreMap.put("배애리", 92);

        System.out.println(scoreMap.entrySet());
        // [반하나=85, 이메론=88, 김사과=90, 오렌지=95, 배애리=92] : key=value 형태로 저장하고 있음
        for(Map.Entry<String, Integer> entry : scoreMap.entrySet()){
            // entry 저장 방식 key=value
            System.out.println(entry.getKey() + ": " + entry.getValue()+"점"); // key, value를 따로 갖고 나옴
            //반하나: 85점
            //이메론: 88점
            //김사과: 90점
            //오렌지: 95점
            //배애리: 92점
        }
        String name = "오렌지";
        System.out.println(name + "의 점수: " + scoreMap.get(name));
        // get 안에 오렌지를 넣어주게 되면, 점수만 출력됨

        // 만약, map에 key를 동일한 걸 집어 넣게 되면? update 된다.
        scoreMap.put("김사과",100);
        System.out.println("김사과의 점수 수정 후 : " + scoreMap.get("김사과"));

        scoreMap.remove("반하나");
        for(Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            // entry 저장 방식 key=value
            System.out.println(entry.getKey() + ": " + entry.getValue() + "점"); // key, value를 따로 갖고 나옴
            // 반하나 없어짐
        }
        System.out.println("전체 학생 수: " + scoreMap.size() + "명");
    }
}
