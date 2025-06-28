package lesson07;

import java.util.*;

@FunctionalInterface
interface Checker {
    boolean check(String UserAnswer, String correctAnswer);
}
public class Ex12_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         Map<String, String> questionMap = new LinkedHashMap<>();
         //HashMap 이니까 Key와 Value가 있을 것
        questionMap.put("자바에서 문자열을 나타내는 클래스는?", "String");
        questionMap.put("자바에서 반복문에 사용하는 키워드는?", "for");
        questionMap.put("자바에서 클래스를 정의할 때 사용하는 키워드는?", "class");
        questionMap.put("자바에서 상속을 표현하는 키워드는?", "extends");
        questionMap.put("자바의 논리 연산자 중 하나는?", "&&");

        List<Map.Entry<String, String>> entries = new ArrayList<>(questionMap.entrySet()) ;
        Collections.shuffle(entries); // 섞어준다

         Checker checker = (user, correct) -> user.trim().equalsIgnoreCase(correct);
        System.out.println("퀴즈 게임 시작");
        int score = 0;
        for (Map.Entry<String, String> entry : entries) {
            String question = entry.getKey();
            String anwser = entry.getValue();
            System.out.println("문제 : " + question);
            System.out.print("답변 입력 : ");
            String userInput = sc.nextLine();

            if (checker.check(userInput, anwser)) {
                System.out.println("정답쓰~!");
                score++;
            } else {
                System.out.println("땡! 정답은 " + anwser + "입니다");
            }
        }
        System.out.println("끝! 당신의 점수는 " + score + "입니다");
        sc.close();
    }
}
