package lesson02;

import java.util.Scanner;

public class Ex06_SwitchFruit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름을 영어로 입력하세요(apple, banana, grape) :");
        String fruit = sc.nextLine();

        String result = switch (fruit) {
            case "apple" -> "사과";
            // case apple에 걸리면 사과를 result에 넣어줄게.
            // 사과는 String이니까 String에 담아주는 것
            case "banana" -> "바나나";
            case "grape" -> "포도";
            case "peach" -> "복숭아";
            case "melon" -> "메론";
            default -> "알 수 없는 과일입니다";
        }; //한 줄로 보기 때문에 세미콜론을 적어줘야한다.

        System.out.println("입력한 과일의 한글 : " + result);
        sc.close();
    }
}
